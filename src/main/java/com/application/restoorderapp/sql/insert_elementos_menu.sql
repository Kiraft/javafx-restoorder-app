USE resto_order;

DELETE FROM elementos_menu;

--Insertar postres
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id) VALUES
(
    "PANQUE AROMA",
    84,
    3
),
(
    "TIRAMISU AROMA",
    100,
    3
),
(
    "TRUFA",
    120,
    3
),
(
    "BROWNIE",
    80,
    3
),
(
    "POLVORONES DE NUEZ",
    68,
    3
);

--Insertar asiatica
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id) VALUES
(
    "SOPA RAMEN",
    105,
    2
),
(
    "ATUN PREPARADO",
    135,
    2
),
(
    "SALMON CON QUESO CREMA",
    149,
    2
),
(
    "KANIKAMA",
    125,
    2
),
(
    "YAKIMESHI",
    91,
    2
);

--Insertar cafe
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id) VALUES
(
    "AMERICANO LIGERO",
    32,
    4
),
(
    "CAFE LATTE SUPREMO",
    76,
    4
),
(
    "CAFE MOKA BLANCO",
    60,
    4
),
(
    "KANIKAMA",
    125,
    4
),
(
    "CAFE SPRESSO",
    91,
    4
);

--Insertar internacional
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id) VALUES
(
    "PECHUGA A LA PARMESANA",
    240,
    1
),
(
    "HAMBURGESA BISTRO",
    235,
    1
),
(
    "ENCHILADAS VERDES",
    198,
    1
),
(
    "CHILAQUILES NATURALES",
    159,
    1
),
(
    "OMELET MEXICANO 172",
    91,
    1
);

