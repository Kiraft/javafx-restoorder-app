USE resto_order;

DELETE FROM asignaciones_empleados_mesas;

INSERT INTO asignaciones_empleados_mesas (mesas_id, empleados_id) VALUES
(
    1,
    1
),
(
    2,
    1
),
(
    3,
    2
),
(
    4,
    2
);