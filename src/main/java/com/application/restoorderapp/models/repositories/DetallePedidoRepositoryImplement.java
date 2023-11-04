package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.DetallePedido;
import com.application.restoorderapp.models.interfaces.Repository;
import com.application.restoorderapp.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DetallePedidoRepositoryImplement implements Repository<DetallePedido> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    @Override
    public List<DetallePedido> listar() {
        return null;
    }

    @Override
    public DetallePedido porId(Long id) {
        return null;
    }

    @Override
    public void guardar(DetallePedido detallePedido) {
        String SQL = "INSERT INTO detalles_ordenes (cantidad, precio_unitario, precio_total, ordenes_id, elementos_menu_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(SQL) ) {
            stmt.setInt(1, detallePedido.getCantidad());
            stmt.setDouble(2, detallePedido.getPrecio_unitario());
            stmt.setDouble(3, detallePedido.getPrecio_total());
            stmt.setLong(4, detallePedido.getOrden().getId());
            stmt.setLong(5, detallePedido.getElementoMenu().getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("CUENTA - No se guardo el registro");
        }
    }

    @Override
    public void eliminar(Long id) {

    }
}
