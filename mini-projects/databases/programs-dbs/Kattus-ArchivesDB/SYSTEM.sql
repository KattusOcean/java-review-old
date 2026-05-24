/* LIBRARY */
CREATE USER archives_space IDENTIFIED BY archives_space_pwd

GRANT
    CREATE SESSION,
    CREATE TABLE,
    CREATE VIEW,
    CREATE TRIGGER,
    CREATE PROCEDURE
TO archives_space

ALTER USER archives_space QUOTA UNLIMITED ON USERS;

------------------------------------------------------------
/* USER */
CREATE USER archives_user IDENTIFIED BY archives_user_pwd

GRANT CREATE SESSION TO archives_user

ALTER USER archives_user QUOTA 0 ON USERS;

GRANT
    SELECT,
    INSERT,
    UPDATE,
    DELETE
ON archives_space.book
TO archives_user;
