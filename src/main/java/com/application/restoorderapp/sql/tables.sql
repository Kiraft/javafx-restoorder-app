-- mysql -h 35.239.87.59 -u root -p
-- lolxx4321

DROP DATABASE IF EXISTS resto_order;

CREATE DATABASE resto_order;

USE resto_order;

CREATE TABLE tipos_empleados(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL
);

CREATE TABLE empleados (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipos_empleados_id INT UNSIGNED NOT NULL, 
    nombre VARCHAR(255) NOT NULL,
    apellido_p VARCHAR(255) NOT NULL,
    apellido_m VARCHAR(255) NOT NULL,
    rfc VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,

    FOREIGN KEY (tipos_empleados_id) REFERENCES tipos_empleados(id)
);

CREATE TABLE cuentas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    empleados_id INT UNSIGNED NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,

    FOREIGN KEY (empleados_id) REFERENCES empleados(id)
);

