/* =========================== PURCHASE PROCEDURE =========================== */
CREATE OR REPLACE PROCEDURE make_purchase (
    p_user_id       users.id%TYPE,
    p_product_ids   IN t_number_table,
    p_quantities    IN t_number_table
) AS
    v_total         NUMBER := 0;
    v_stock         NUMBER;
    v_price         NUMBER;
    v_balance       NUMBER;
    v_receipt_id    NUMBER;


BEGIN
    --------------------------------------------------------------------------
    -- INITIAL CHECKS
    --------------------------------------------------------------------------

    -- Both collections must have the same number of elements
    IF p_product_ids.COUNT != p_quantities.COUNT THEN
        RAISE_APPLICATION_ERROR(-20001, 'Products and quantities count mismatch');
    END IF;

    -- Prevent empty purchase operations
    IF p_product_ids.COUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Empty purchase');
    END IF;

    ----------------------------------------------------------------------------
    -- PHASE 1:
    -- Validate product stock and calculate total purchase amount
    ----------------------------------------------------------------------------
    FOR i IN 1 .. p_product_ids.COUNT LOOP
        
        -- Retrieve current product price and available stock
        SELECT price, stock
        INTO v_price, v_stock
        FROM products
        WHERE id = p_product_ids(i);

        -- Ensure sufficient stock for requested quantity
        IF v_stock < p_quantities(i) THEN
            RAISE_APPLICATION_ERROR(-20003, 'Insufficient product stock. Product ID: ' || p_product_ids(i));
        END IF;

        -- Accumulate total using current product price
        v_total := v_total + (v_price * p_quantities(i));
        
    END LOOP;


    ----------------------------------------------------------------------------
    -- CHECK USER BALANCE
    ----------------------------------------------------------------------------
    
    -- Retrieve user balance
    SELECT balance
    INTO v_balance
    FROM users
    WHERE id = p_user_id;

    -- Ensure user has sufficient balance to complete purchase
    IF v_balance < v_total THEN
        RAISE_APPLICATION_ERROR(-20004, 'Insufficient balance');
    END IF;


    ----------------------------------------------------------------------------
    -- CREATE PURCHASE RECEIPT
    ----------------------------------------------------------------------------
    
    -- Insert receipt header for the purchase operation
    INSERT INTO receipts (user_id, type, date_op, total)
    VALUES (p_user_id, 'PURCHASE', SYSDATE, v_total)
    RETURNING id INTO v_receipt_id;


    ----------------------------------------------------------------------------
    -- PHASE 2:
    -- Persist receipt items and decrease product stock
    ----------------------------------------------------------------------------
    FOR i IN 1 .. p_product_ids.COUNT LOOP
        
        -- Read product price to ensure consistency with receipt items
        SELECT price, stock
        INTO v_price, v_stock
        FROM products
        WHERE id = p_product_ids(i);

        -- Insert purchase line item
        INSERT INTO receipt_item (receipt_id, product_id, unit_price, quantity, subtotal)
        VALUES (v_receipt_id, p_product_ids(i), v_price, p_quantities(i), (v_price * p_quantities(i)));

        -- Decrease available product stock
        UPDATE products
        SET stock = stock - p_quantities(i)
        WHERE id = p_product_ids(i);
        
    END LOOP;


    ----------------------------------------------------------------------------
    -- UPDATE USER BALANCE
    ----------------------------------------------------------------------------

    -- Deduct total purchase amount from user balance
    UPDATE users
    SET balance = balance - v_total
    WHERE id = p_user_id;

    -- Save changes
    COMMIT;


EXCEPTION
    -- Roll back all changes on any error
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END make_purchase;
/

/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */

/* ============================ RETURN PROCEDURE ============================ */
CREATE OR REPLACE PROCEDURE return_purchase (
    p_user_id       users.id%TYPE,
    p_product_ids   IN t_number_table,
    p_quantities    IN t_number_table,
    p_receipt_id    receipts.id%TYPE

) AS
    v_total         NUMBER := 0;
    v_price         NUMBER;
    v_quantity      NUMBER;
    v_user_id       NUMBER;
    v_stock         NUMBER;
    v_receipt_id    NUMBER;
    
BEGIN
    ----------------------------------------------------------------------------
    -- GENERAL CHECKS
    ----------------------------------------------------------------------------
    
    -- Both collections must have same cardinality
    IF p_product_ids.COUNT != p_quantities.COUNT THEN
        RAISE_APPLICATION_ERROR(-20001, 'Products and quantities count mismatch');
    END IF;

    -- Prevent empty return operations    
    IF p_product_ids.COUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Empty return');
    END IF;
    
    
    ----------------------------------------------------------------------------
    -- PHASE 1
    -- Validation and total calculation using historical receipt data
    ----------------------------------------------------------------------------
    FOR i IN 1 .. p_product_ids.COUNT LOOP
    
        -- Fetch original purchase data
        SELECT ri.unit_price, ri.quantity, r.user_id
        INTO v_price, v_quantity, v_user_id
        FROM receipt_item ri
        JOIN receipts r ON ri.receipt_id = r.id
        WHERE ri.receipt_id = p_receipt_id
            AND ri.product_id = p_product_ids(i);
        
        -- Prevent returning more than originally purchased
        IF p_quantities(i) > v_quantity THEN
            RAISE_APPLICATION_ERROR(-20003, 'Purchased quantity was lower. Real quantity: ' || v_quantity);
        END IF;
        
        -- Ensure the receipt belongs to the requesting user
        IF p_user_id <> v_user_id THEN
            RAISE_APPLICATION_ERROR(-20004, 'Purchase made by a different client');
        END IF;
        
        -- Accumulate refund total using historical price
        v_total := v_total + (v_price * p_quantities(i));
    END LOOP;


    ----------------------------------------------------------------------------
    -- CREATE RETURN RECEIPT
    ----------------------------------------------------------------------------
    INSERT INTO receipts (user_id, type, date_op, total)
    VALUES (p_user_id, 'RETURN', SYSDATE, v_total)
    RETURNING id INTO v_receipt_id;


    ----------------------------------------------------------------------------
    -- PHASE 2:
    -- Persist return items and restore product stock
    ----------------------------------------------------------------------------
    FOR i IN 1 .. p_product_ids.COUNT LOOP
    
        SELECT unit_price
        INTO v_price
        FROM receipt_item
        WHERE receipt_id = p_receipt_id
          AND product_id = p_product_ids(i);
    
        INSERT INTO receipt_item (receipt_id, product_id, unit_price, quantity, subtotal)
        VALUES (v_receipt_id, p_product_ids(i), v_price, p_quantities(i), v_price * p_quantities(i));
    
        -- Restore product stock
        UPDATE products
        SET stock = stock + p_quantities(i)
        WHERE id = p_product_ids(i);

    END LOOP;

    -- Refund user balance
    UPDATE users
    SET balance = balance + v_total
    WHERE id = p_user_id;

    -- Save changes
    COMMIT;
    
    
EXCEPTION
    -- Explicit error when a product does not belong to the receipt
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20005, 'Product not found in receipt');

    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END return_purchase;
/