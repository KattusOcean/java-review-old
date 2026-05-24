## Database setup
Order of execution:
1. 01_schema.sql
2. 02_types.sql
3. 03_procedures.sql
4. 04_triggers.sql

## Users & privileges (example)
1. **admin**
   - Privileges: CREATE SESSION, CREATE TABLE, CREATE PROCEDURE, CREATE SEQUENCE, CREATE TYPE, CREATE TRIGGER
   - Should own the schema (tables, procedures, triggers)

2. **client**
   - Privileges: CREATE SESSION
   - Read-only access to `products`

Tested with Oracle XE 21c.
