CREATE TABLE users (
    user_id     VARCHAR2(20) PRIMARY KEY,
    user_name   VARCHAR2(50) NOT NULL,
    user_age    NUMBER(3)
);

INSERT INTO users
VALUES ('10110110A', 'Test', '0');

select * from users;

commit;

rollback;