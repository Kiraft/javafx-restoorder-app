package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.Empleado;
import com.application.restoorderapp.models.TipoEmpleado;
import com.application.restoorderapp.models.interfaces.Repository;
import com.application.restoorderapp.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoRepositoryImplement implements Repository<Empleado> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    @Override
    public List<Empleado> listar() {
        return null;
    }

    @Override
    public Empleado porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Empleado empleado) {

    }

    public void update(Empleado empleado){
        String sql = "UPDATE empleados SET id = ?, tipos_empleados_id = ?, nombre = ?, apellido_p =?, apellido_m =?, rfc=?, email=?, code=?, has_account =? WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setLong(1, empleado.getId());
            stmt.setLong(2, empleado.getTipoEmpleado().getId());
            stmt.setString(3, empleado.getNombre());
            stmt.setString(4, empleado.getApellidoPaterno());
            stmt.setString(5, empleado.getApellidoMaterno());
            stmt.setString(6, empleado.getRfc());
            stmt.setString(7, empleado.getEmail());
            stmt.setString(8, empleado.getCode());
            stmt.setBoolean(9, empleado.getHas_account());
            stmt.setLong(10, empleado.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Empleado - No se hizo el update");

        }
    }

    @Override
    public void eliminar(Long id) {

    }

    public Empleado porCode(String code){
        Empleado e = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM empleados AS e INNER JOIN tipos_empleados AS te ON e.tipos_empleados_id = te.id WHERE e.code = ?;")) {
            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    e = new Empleado();
                    e.setId(rs.getLong("id"));
                    e.setNombre(rs.getString("nombre"));
                    e.setApellidoPaterno(rs.getString("apellido_p"));
                    e.setApellidoMaterno(rs.getString("apellido_m"));
                    e.setRfc(rs.getString("rfc"));
                    e.setEmail(rs.getString("email"));
                    e.setCode(rs.getString("code"));
                    e.setHas_account(rs.getBoolean("has_account"));

                    TipoEmpleado te = new TipoEmpleado();
                    te.setId(rs.getLong("id"));
                    te.setTipo(rs.getString("tipo"));
                    e.setTipoEmpleado(te);
                }
            }
        } catch (SQLException s) {
            System.out.println("Empleado - Por code");
        }
        return e;
    }
}
