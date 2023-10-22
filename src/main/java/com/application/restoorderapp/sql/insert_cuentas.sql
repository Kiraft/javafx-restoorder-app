-- mysql -h 35.239.87.59 -u root -p
-- lolxx4321

USE resto_order;

DELETE FROM cuentas;

INSERT INTO cuentas (empleados_id, usuario, password) VALUES
 (
    1,
    "kiraft",
    "4321"
 ),
 (
    3,
    "yamir",
    "4321"
 );

 SOURCE insert_categorias_menu.sql;