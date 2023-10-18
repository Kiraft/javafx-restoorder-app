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

public class CuentaRepositoryImplement implements Repository<Cuenta> {
    @Override
    public List<Cuenta> listar() {
        return null;
    }

    @Override
    public Cuenta porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Cuenta alumno) {

    }

    @Override
    public void eliminar(Long id) {

    }

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    public int login(String usuario, String password) {
        int state = -1;

        try (PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM cuentas WHERE usuario=? AND password=?")){

            pst.setString(1, usuario);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    state = 1;
                } else {
                    state = 0;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return state;
    }

    public Cuenta porUsuario(String usuario) {
        Cuenta c = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM cuentas AS c INNER JOIN empleados AS e ON c.empleados_id = e.id INNER JOIN tipos_empleados AS te ON e.tipos_empleados_id = te.id WHERE c.usuario = ?;")) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    c = new Cuenta();
                    c.setId(rs.getLong("id"));
                    c.setUsuario(rs.getString("usuario"));
                    c.setPassword(rs.getString("password"));

                    Empleado e = new Empleado();
                    e.setId(rs.getLong("id"));
                    e.setNombre(rs.getString("nombre"));
                    e.setApellidoPaterno(rs.getString("apellido_p"));
                    e.setApellidoMaterno(rs.getString("apellido_m"));
                    e.setRfc(rs.getString("rfc"));
                    e.setEmail(rs.getString("email"));
                    e.setCode(rs.getString("code"));

                    TipoEmpleado te = new TipoEmpleado();
                    te.setId(rs.getLong("id"));
                    te.setTipo(rs.getString("tipo"));
                    e.setTipoEmpleado(te);
                    c.setEmpleado(e);
                }
            }
        } catch (SQLException e) {

        }

        return c;
    }
}
