
-- Tabla Bus
CREATE TABLE Bus (
    register VARCHAR(10) PRIMARY KEY,
    type VARCHAR(20),
    license VARCHAR(20)
);

-- Tabla Driver
CREATE TABLE Driver (
    numdriver INT PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50)
);

-- Tabla Place
CREATE TABLE Place (
    idplace INT PRIMARY KEY,
    cp VARCHAR(10),
    city VARCHAR(50),
    site VARCHAR(50)
);

-- Tabla intermedia B-D-P (relación ternaria)
CREATE TABLE BDP (
    register VARCHAR(10),
    numdriver INT,
    idplace INT,
    day_of_week VARCHAR(15),
    PRIMARY KEY (register, numdriver, idplace),
    FOREIGN KEY (register) REFERENCES Bus(register),
    FOREIGN KEY (numdriver) REFERENCES Driver(numdriver),
    FOREIGN KEY (idplace) REFERENCES Place(idplace)
);

-- Insertamos buses
INSERT ALL
    INTO Bus VALUES ('B001', 'Urbano', 'LIC001')
    INTO Bus VALUES ('B002', 'Interurbano', 'LIC002')
    INTO Bus VALUES ('B003', 'Turismo', 'LIC003')
    INTO Bus VALUES ('B004', 'Escolar', 'LIC004')
    INTO Bus VALUES ('B005', 'Urbano', 'LIC005')
    INTO Bus VALUES ('B006', 'Turismo', 'LIC006')
    INTO Bus VALUES ('B007', 'Interurbano', 'LIC007')
    INTO Bus VALUES ('B008', 'Urbano', 'LIC008')
    INTO Bus VALUES ('B009', 'Escolar', 'LIC009')
    INTO Bus VALUES ('B010', 'Turismo', 'LIC010')
SELECT 1 FROM DUAL;

-- Insertamos conductores
INSERT ALL
    INTO Driver VALUES (101, 'Carlos', 'García')
    INTO Driver VALUES (102, 'Lucía', 'Pérez')
    INTO Driver VALUES (103, 'Manuel', 'Martín')
    INTO Driver VALUES (104, 'Laura', 'López')
    INTO Driver VALUES (105, 'Javier', 'Sánchez')
    INTO Driver VALUES (106, 'Marta', 'Fernández')
    INTO Driver VALUES (107, 'David', 'Ruiz')
    INTO Driver VALUES (108, 'Ana', 'Díaz')
    INTO Driver VALUES (109, 'Pablo', 'Gómez')
    INTO Driver VALUES (110, 'Elena', 'Navarro')
SELECT 1 FROM DUAL;

-- Insertamos lugares
INSERT ALL
    INTO Place VALUES (1, '14001', 'Córdoba', 'Centro')
    INTO Place VALUES (2, '28013', 'Madrid', 'Sol')
    INTO Place VALUES (3, '41001', 'Sevilla', 'Triana')
    INTO Place VALUES (4, '08001', 'Barcelona', 'Gótico')
    INTO Place VALUES (5, '46001', 'Valencia', 'Carmen')
    INTO Place VALUES (6, '29001', 'Málaga', 'Soho')
    INTO Place VALUES (7, '03001', 'Alicante', 'Explanada')
    INTO Place VALUES (8, '35001', 'Las Palmas', 'Vegueta')
    INTO Place VALUES (9, '07001', 'Palma', 'Catedral')
    INTO Place VALUES (10, '15001', 'A Coruña', 'Marina')
SELECT 1 FROM DUAL;

-- Insertamos datos en la relación BDP
INSERT ALL 
    INTO BDP VALUES ('B001', 101, 1, 'Monday')
    INTO BDP VALUES ('B002', 102, 2, 'Tuesday')
    INTO BDP VALUES ('B003', 103, 3, 'Wednesday')
    INTO BDP VALUES ('B004', 104, 4, 'Thursday')
    INTO BDP VALUES ('B005', 105, 5, 'Friday')
    INTO BDP VALUES ('B006', 106, 6, 'Monday')
    INTO BDP VALUES ('B007', 107, 7, 'Tuesday')
    INTO BDP VALUES ('B008', 108, 8, 'Wednesday')
    INTO BDP VALUES ('B009', 109, 9, 'Thursday')
    INTO BDP VALUES ('B010', 110, 10, 'Friday')
SELECT 1 FROM DUAL;

-- CONSULTAS ÚTILES

-- 1. Mostrar qué conductor conduce qué bus a qué lugar en qué día
SELECT 
    d.name || ' ' || d.surname AS driver_name,
    b.register AS bus,
    p.city || ' - ' || p.site AS destination,
    bd.day_of_week
FROM BDP bd
JOIN Driver d ON bd.numdriver = d.numdriver
JOIN Bus b ON bd.register = b.register
JOIN Place p ON bd.idplace = p.idplace;

-- 2. Mostrar todos los buses con su tipo y licencia
SELECT * FROM Bus;

-- 3. Mostrar todos los conductores que van a Sevilla
SELECT DISTINCT d.name, d.surname
FROM BDP bd
JOIN Driver d ON bd.numdriver = d.numdriver
JOIN Place p ON bd.idplace = p.idplace
WHERE p.city = 'Sevilla';

-- 4. Contar cuántos viajes se realizan cada día de la semana
SELECT day_of_week, COUNT(*) AS num_viajes
FROM BDP
GROUP BY day_of_week;

-- 5. Listar los lugares que visitan más de un bus
SELECT p.city, p.site, COUNT(DISTINCT bd.register) AS num_buses
FROM BDP bd
JOIN Place p ON bd.idplace = p.idplace
GROUP BY p.city, p.site
HAVING COUNT(DISTINCT bd.register) > 1;
