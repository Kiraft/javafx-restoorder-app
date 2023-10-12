-- mysql -h 35.239.87.59 -u root -p
-- lolxx4321

USE resto_order;

DELETE FROM cuentas;

INSERT INTO cuentas (empleados_id, usuario, password) VALUES
 (
    13,
    "kiraft",
    "4321"
 ),
 (
    14,
    "alix",
    "4321"
 ),
 (
    13,
    "yamir",
    "4321"
 );