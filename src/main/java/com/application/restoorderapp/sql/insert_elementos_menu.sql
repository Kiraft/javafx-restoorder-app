USE resto_order;

DELETE FROM elementos_menu;

--Insertar postres
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img, descripcion) VALUES
(
    "PANQUE AROMA",
    84,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/panque-aroma.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "TIRAMISU AROMA",
    100,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/tiramisu.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "TRUFA",
    120,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/trufa-aroma.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "BROWNIE",
    80,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/browne.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "POLVORONES DE NUEZ",
    68,
    3,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/postres/polvorones-nuez.PNG',
    "AQUI VA LA DESCRIPCION"
);

--Insertar asiatica
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img, descripcion) VALUES
(
    "SOPA RAMEN",
    105,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/ramen.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "ATUN PREPARADO",
    135,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/atun-preparado.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "SALMON CON QUESO CREMA",
    149,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/salon-queso-crema.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "KANIKAMA",
    125,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/kanikama.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "YAKIMESHI",
    91,
    2,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/asiatica/yakimeshi.PNG',
    "AQUI VA LA DESCRIPCION"
);

--Insertar cafe
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img, descripcion) VALUES
(
    "AMERICANO LIGERO",
    32,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-ligero.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "CAFE LATTE SUPREMO",
    76,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-latte.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "CAFE MOKA BLANCO",
    60,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-moka.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "PRENSA FRANCESA",
    125,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/prensa-francesa.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "CAFE SPRESSO",
    91,
    4,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/cafe/cafe-spresso.PNG',
    "AQUI VA LA DESCRIPCION"
);

--Insertar internacional
INSERT INTO elementos_menu (nombre, precio, categorias_menu_id, img, descripcion) VALUES
(
    "PECHUGA A LA PARMESANA",
    240,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/lechuga-parmesana.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "HAMBURGESA BISTRO",
    235,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/hamburgesa-bistro.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "ENCHILADAS VERDES",
    198,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/enchiladas.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "CHILAQUILES NATURALES",
    159,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/chilaquiles-naturales.PNG',
    "AQUI VA LA DESCRIPCION"
),
(
    "OMELET MEXICANO",
    91,
    1,
    'src/main/resources/com/application/restoorderapp/assets/img-platillos/internacional/omelet-mexicano.PNG',
    "AQUI VA LA DESCRIPCION"
);

-- SOURCE insert_mesas.sql;
