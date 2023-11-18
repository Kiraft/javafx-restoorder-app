-- mysql -h 35.232.239.181 -u root -p
-- lolxx4321

USE resto_order;

DELETE FROM tipos_empleados;

INSERT INTO tipos_empleados (tipo) VALUES ("MESERO"), ("COCINERO"), ("CAJERO"), ("GERENTE"), ("LIMPIEZA");

SOURCE insert_empleados.sql;