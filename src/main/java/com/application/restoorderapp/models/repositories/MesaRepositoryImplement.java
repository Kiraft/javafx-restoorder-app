package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Empleado;
import com.application.restoorderapp.models.Mesa;
import com.application.restoorderapp.models.TipoEmpleado;
import com.application.restoorderapp.models.interfaces.Repository;
import com.application.restoorderapp.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaRepositoryImplement implements Repository<Mesa> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    @Override
    public List<Mesa> listar() {
        return null;
    }

    @Override
    public Mesa porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Mesa alumno) {

    }

    @Override
    public void eliminar(Long id) {

    }

    public List<Mesa> listarPorEmpleado(Empleado em) {
        List<Mesa> mesas = new ArrayList<>();
        String sql =  "SELECT * FROM asignaciones_empleados_mesas AS am INNER JOIN mesas ON (am.mesas_id = mesas.id) WHERE am.empleados_id = ?;";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setLong(1, em.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Mesa m = new Mesa();
                    m.setId(rs.getLong("mesas_id"));
                    m.setCapacidad(rs.getInt("capacidad"));
                    m.setStatus(rs.getBoolean("status"));
                    mesas.add(m);
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

        return mesas;
    }
}
