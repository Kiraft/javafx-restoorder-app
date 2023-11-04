USE resto_order;

DELETE FROM elementos_menu;

--Insertar postres
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img) VALUES
(
    "PANQUE AROMA",
    84,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/panque-aroma.PNG'
),
(
    "TIRAMISU AROMA",
    100,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/tiramisu.PNG'
),
(
    "TRUFA",
    120,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/trufa-aroma.PNG'
),
(
    "BROWNIE",
    80,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/browne.PNG'
),
(
    "POLVORONES DE NUEZ",
    68,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/polvorones-nuez.PNG'
);

--Insertar asiatica
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img) VALUES
(
    "SOPA RAMEN",
    105,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/ramen.PNG'
),
(
    "ATUN PREPARADO",
    135,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/atun-preparado.PNG'
),
(
    "SALMON CON QUESO CREMA",
    149,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/salon-queso-crema.PNG'
),
(
    "KANIKAMA",
    125,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/kanikama.PNG'
),
(
    "YAKIMESHI",
    91,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/yakimeshi.PNG'
);

--Insertar cafe
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img) VALUES
(
    "AMERICANO LIGERO",
    32,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-ligero.PNG'
),
(
    "CAFE LATTE SUPREMO",
    76,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-latte.PNG'
),
(
    "CAFE MOKA BLANCO",
    60,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-moka.PNG'
),
(
    "PRENSA FRANCESA",
    125,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/prensa-francesa.PNG'
),
(
    "CAFE SPRESSO",
    91,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-spresso.PNG'
);

--Insertar internacional
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img) VALUES
(
    "PECHUGA A LA PARMESANA",
    240,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/lechuga-parmesana.PNG'
),
(
    "HAMBURGESA BISTRO",
    235,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/hamburgesa-bistro.PNG'
),
(
    "ENCHILADAS VERDES",
    198,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/enchiladas.PNG'
),
(
    "CHILAQUILES NATURALES",
    159,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/chilaquiles-naturales.PNG'
),
(
    "OMELET MEXICANO",
    91,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/omelet-mexicano.PNG'
);


-- SOURCE insert_mesas.sql;
