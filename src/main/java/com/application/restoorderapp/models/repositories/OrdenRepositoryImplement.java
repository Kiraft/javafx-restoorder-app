package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Empleado;
import com.application.restoorderapp.models.Orden;
import com.application.restoorderapp.models.TipoEmpleado;
import com.application.restoorderapp.models.interfaces.Repository;
import com.application.restoorderapp.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenRepositoryImplement implements Repository<Orden> {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    @Override
    public List<Orden> listar() {
        List<Orden> ordenes = new ArrayList<>();

        String sql = "SELECT * FROM ordenes AS o INNER JOIN empleados AS e ON o.empleados_id = e.id INNER JOIN tipos_empleados AS te ON e.tipos_empleados_id = te.id;";
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Orden o = new Orden();
                o.setId(rs.getLong("id"));
                o.setFecha(rs.getDate("fecha"));
                o.setEstado_preparacion(rs.getString("estado_preparacion"));
                Empleado e = new Empleado();
                e.setId(rs.getLong("e.id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidoPaterno(rs.getString("apellido_p"));
                e.setApellidoMaterno(rs.getString("apellido_m"));
                e.setRfc(rs.getString("rfc"));
                e.setEmail(rs.getString("email"));
                e.setCode(rs.getString("code"));
                e.setHas_account(rs.getBoolean("has_account"));
                TipoEmpleado te = new TipoEmpleado();
                te.setId(rs.getLong("te.id"));
                te.setTipo(rs.getString("tipo"));
                e.setTipoEmpleado(te);
                o.setEmpleado(e);
                ordenes.add(o);
            }

        } catch (SQLException e) {

        }

        return ordenes;
    }

    @Override
    public Orden porId(Long id) {
        String sql = "SELECT * FROM ordenes as o INNER JOIN empleados as e ON (o.empleados_id = e.id) where o.id = ?";
//        Orden o = null;
//        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
//            stmt.setLong(1, id);
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    o = new Orden();
//                    o.setId(rs.getLong("id"));
//                    o.setFecha(rs.getDate("fecha"));
//                    o.setEstado_preparacion(rs.getString("estado_preparacion"));
//                    Empleado e = new Empleado();
//                    e.setNombre();
//                    o.setEmpleado();
//                }
//            }
//        } catch (SQLException e) {
//
//        }
        return null;
    }

    @Override
    public void guardar(Orden order) {
        String sql = "INSERT INTO ordenes (fecha, estado_preparacion, empleados_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql) ) {
            stmt.setDate(1, new Date(order.getFecha().getTime()));
            stmt.setString(2, order.getEstado_preparacion());
            stmt.setLong(3, order.getEmpleado().getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("CUENTA - No se guardo el registro");
        }
    }

    public Long guardarReturndId(Orden order) {
        String sql = "INSERT INTO ordenes (fecha, estado_preparacion, empleados_id) VALUES (?, ?, ?)";
        Long idGenerado = null; // Inicializar con null si no se genera una clave primaria

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setDate(1, new Date(order.getFecha().getTime()));
            stmt.setString(2, order.getEstado_preparacion());
            stmt.setLong(3, order.getEmpleado().getId());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 1) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idGenerado = generatedKeys.getLong(1); // Obtiene la clave primaria generada
                    System.out.println("ID generado: " + idGenerado);
                    order.setId(idGenerado); // Establecer la clave primaria generada en el objeto Order
                }
            }
        } catch (SQLException e) {
            System.out.println("CUENTA - No se guardó el registro");
            System.out.println("Mensaje de Error: " + e.getMessage());
            System.out.println("Código de Error: " + e.getErrorCode());
            System.out.println("Estado SQL: " + e.getSQLState());

            // Recorrer la cadena de excepciones si hay más de una
            while (e.getNextException() != null) {
                e = e.getNextException();
                System.out.println("Mensaje de Error: " + e.getMessage());
                System.out.println("Código de Error: " + e.getErrorCode());
                System.out.println("Estado SQL: " + e.getSQLState());
            }
        }
        return idGenerado;

    }


    @Override
    public void eliminar(Long id) {

    }

    public void update(Orden alumno) {

    }
}
