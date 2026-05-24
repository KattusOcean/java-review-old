--------------------------------------------------------------------------------
-- INSERTS_U
-- Users
--------------------------------------------------------------------------------

-- Admins
INSERT INTO users (name, email, password, role, balance) VALUES ('admin1', 'admin1@kamazon.com', 'admin1234', 'admin', NULL);
INSERT INTO users (name, email, password, role, balance) VALUES ('admin2', 'admin2@kamazon.com', 'admin1234', 'admin', NULL);
INSERT INTO users (name, email, password, role, balance) VALUES ('admin3', 'admin3@kamazon.com', 'admin1234', 'admin', NULL);
INSERT INTO users (name, email, password, role, balance) VALUES ('admin4', 'admin4@kamazon.com', 'admin1234', 'admin', NULL);
INSERT INTO users (name, email, password, role, balance) VALUES ('admin5', 'admin5@kamazon.com', 'admin1234', 'admin', NULL);

-- Clients
INSERT INTO users (name, email, password, role, balance) VALUES ('client1', 'client1@kamazon.com', 'client1234', 'client', 100);
INSERT INTO users (name, email, password, role, balance) VALUES ('client2', 'client2@kamazon.com', 'client1234', 'client', 50);
INSERT INTO users (name, email, password, role, balance) VALUES ('client3', 'client3@kamazon.com', 'client1234', 'client', 75);
INSERT INTO users (name, email, password, role, balance) VALUES ('client4', 'client4@kamazon.com', 'client1234', 'client', 200);
INSERT INTO users (name, email, password, role, balance) VALUES ('client5', 'client5@kamazon.com', 'client1234', 'client', 150);
INSERT INTO users (name, email, password, role, balance) VALUES ('client6', 'client6@kamazon.com', 'client1234', 'client', 0);
INSERT INTO users (name, email, password, role, balance) VALUES ('client7', 'client7@kamazon.com', 'client1234', 'client', 500);
INSERT INTO users (name, email, password, role, balance) VALUES ('client8', 'client8@kamazon.com', 'client1234', 'client', 300);
INSERT INTO users (name, email, password, role, balance) VALUES ('client9', 'client9@kamazon.com', 'client1234', 'client', 25);
INSERT INTO users (name, email, password, role, balance) VALUES ('client10', 'client10@kamazon.com', 'client1234', 'client', 80);


--------------------------------------------------------------------------------
-- INSERTS_P
-- Products
--------------------------------------------------------------------------------

-- Clothing
INSERT INTO products (name, price, category, stock, rating) VALUES ('shirt', 20, 'clothing', 10, 4.5);
INSERT INTO products (name, price, category, stock, rating) VALUES ('jeans', 40, 'clothing', 15, 4.3);
INSERT INTO products (name, price, category, stock, rating) VALUES ('jacket', 60, 'clothing', 8, 4.6);
INSERT INTO products (name, price, category, stock, rating) VALUES ('socks', 5, 'clothing', 50, 4.1);
INSERT INTO products (name, price, category, stock, rating) VALUES ('hat', 12, 'clothing', 20, 4.0);

-- Sport
INSERT INTO products (name, price, category, stock, rating) VALUES ('bicycle', 150, 'sport', 5, 4.8);
INSERT INTO products (name, price, category, stock, rating) VALUES ('tennis racket', 70, 'sport', 10, 4.4);
INSERT INTO products (name, price, category, stock, rating) VALUES ('soccer ball', 25, 'sport', 30, 4.7);
INSERT INTO products (name, price, category, stock, rating) VALUES ('yoga mat', 20, 'sport', 25, 4.5);
INSERT INTO products (name, price, category, stock, rating) VALUES ('basketball', 30, 'sport', 18, 4.6);

-- Technology
INSERT INTO products (name, price, category, stock, rating) VALUES ('headphone', 50, 'technology', 8, 4.2);
INSERT INTO products (name, price, category, stock, rating) VALUES ('smartphone', 400, 'technology', 12, 4.7);
INSERT INTO products (name, price, category, stock, rating) VALUES ('laptop', 800, 'technology', 5, 4.8);
INSERT INTO products (name, price, category, stock, rating) VALUES ('tablet', 300, 'technology', 10, 4.4);
INSERT INTO products (name, price, category, stock, rating) VALUES ('smartwatch', 120, 'technology', 15, 4.3);

-- Food
INSERT INTO products (name, price, category, stock, rating) VALUES ('apple', 1.20, 'food', 42, 5);
INSERT INTO products (name, price, category, stock, rating) VALUES ('banana', 0.80, 'food', 50, 4.8);
INSERT INTO products (name, price, category, stock, rating) VALUES ('bread', 1.50, 'food', 30, 4.5);
INSERT INTO products (name, price, category, stock, rating) VALUES ('milk', 0.99, 'food', 25, 4.6);
INSERT INTO products (name, price, category, stock, rating) VALUES ('cheese', 3.50, 'food', 20, 4.7);

-- Books
INSERT INTO products (name, price, category, stock, rating) VALUES ('The Great Gatsby', 15, 'books', 10, 4.9);
INSERT INTO products (name, price, category, stock, rating) VALUES ('1984', 12, 'books', 15, 4.8);
INSERT INTO products (name, price, category, stock, rating) VALUES ('Moby Dick', 18, 'books', 8, 4.4);
INSERT INTO products (name, price, category, stock, rating) VALUES ('Harry Potter', 25, 'books', 20, 4.9);
INSERT INTO products (name, price, category, stock, rating) VALUES ('Lord of the Rings', 30, 'books', 12, 4.8);


--------------------------------------------------------------------------------
-- PROCEDURES_P
-- Purchases
--------------------------------------------------------------------------------

-- Client 1001 purchases 3 shirts y 1 jean
DECLARE
    v_products t_number_table := t_number_table(10000, 10001);
    v_quantities t_number_table := t_number_table(3, 1);
BEGIN
    make_purchase(1001, v_products, v_quantities);
END;
/

-- Client 1002 purchases 1 bicycle y 2 soccer balls
DECLARE
    v_products t_number_table := t_number_table(10005, 10007);
    v_quantities t_number_table := t_number_table(1, 2);
BEGIN
    make_purchase(1002, v_products, v_quantities);
END;
/

-- Client 1003 purchases 1 smartphone y 2 headphones
DECLARE
    v_products t_number_table := t_number_table(10010, 10006);
    v_quantities t_number_table := t_number_table(1, 2);
BEGIN
    make_purchase(1003, v_products, v_quantities);
END;
/

-- Client 1004 purchases 5 apples y 2L of milk
DECLARE
    v_products t_number_table := t_number_table(10015, 10018);
    v_quantities t_number_table := t_number_table(5, 2);
BEGIN
    make_purchase(1004, v_products, v_quantities);
END;
/


--------------------------------------------------------------------------------
-- PROCEDURES_R
-- Returns
--------------------------------------------------------------------------------

-- Client 1001 returns 1 jean
DECLARE
    v_products t_number_table := t_number_table(10001);
    v_quantities t_number_table := t_number_table(1);
BEGIN
    return_purchase(1001, v_products, v_quantities, 1); -- 1 = ID del recibo
END;
/

-- Client 1002 returns 1 soccer ball
DECLARE
    v_products t_number_table := t_number_table(10007);
    v_quantities t_number_table := t_number_table(1);
BEGIN
    return_purchase(1002, v_products, v_quantities, 2);
END;
/

-- Client 1003 returns 2 headphones
DECLARE
    v_products t_number_table := t_number_table(10006);
    v_quantities t_number_table := t_number_table(2);
BEGIN
    return_purchase(1003, v_products, v_quantities, 3);
END;
/

-- Client 1004 returns 3 apples
DECLARE
    v_products t_number_table := t_number_table(10015);
    v_quantities t_number_table := t_number_table(3);
BEGIN
    return_purchase(1004, v_products, v_quantities, 4);
END;
/



--------------------------------------------------------------------------------
-- SEARCH QUERIES
--------------------------------------------------------------------------------
SELECT * FROM users;
SELECT * FROM products;
SELECT * FROM receipts;
SELECT * FROM receipt_item;

UPDATE users
SET balance = 1000
WHERE name = 'Jose';

SELECT r.id, u.email, r.type, r.date_op, ri.product_id, ri.quantity, ri.subtotal, r.total
FROM receipts r
JOIN users u ON r.user_id = u.id
JOIN receipt_item ri ON r.id = ri.receipt_id
WHERE LOWER(u.email) = LOWER('alex@gmail.com');


--------------------------------------------------------------------------------
-- DROP TABLES
--------------------------------------------------------------------------------
DROP TABLE receipt_item;
DROP TABLE receipts;
DROP TABLE products;
DROP TABLE users;