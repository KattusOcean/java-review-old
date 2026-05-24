/* ===== TRIGGERS ===== */
CREATE OR REPLACE TRIGGER trg_users_upper
    BEFORE INSERT OR UPDATE ON users
    FOR EACH ROW
BEGIN
    :NEW.role := UPPER(:NEW.role);
END;
/

CREATE OR REPLACE TRIGGER trg_products_upper
    BEFORE INSERT OR UPDATE ON products
    FOR EACH ROW
BEGIN
    :NEW.category := UPPER(:NEW.category);
END;
/