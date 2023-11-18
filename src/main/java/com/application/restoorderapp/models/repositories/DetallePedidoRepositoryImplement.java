package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Categoria;
import com.application.restoorderapp.models.DetallePedido;
import com.application.restoorderapp.models.ElementoMenu;
import com.application.restoorderapp.models.Orden;
import com.application.restoorderapp.models.interfaces.Repository;
import com.application.restoorderapp.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<DetallePedido> listarPorIdOrden(Orden o) {
        List<DetallePedido> detallePedidosPorIdOrden = new ArrayList<>();
        String sql = "SELECT * FROM detalles_ordenes AS do INNER JOIN elementos_menu AS em ON (do.elementos_menu_id = em.id) INNER JOIN categorias_menu AS cm ON (em.categorias_menu_id = cm.id) WHERE do.ordenes_id = ?";

        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {

            pst.setLong(1, o.getId());
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    DetallePedido dp = new DetallePedido();
                    dp.setId(rs.getLong("do.id"));
                    dp.setCantidad(rs.getInt("cantidad"));
                    dp.setPrecio_total(rs.getDouble("precio_total"));
                    dp.setPrecio_unitario(rs.getDouble("precio_total"));
                    dp.setOrden(o);
                    ElementoMenu em = new ElementoMenu();
                    em.setId(rs.getLong("em.id"));
                    em.setNombre(rs.getString("nombre"));
                    em.setPrecio(rs.getDouble("precio"));
                    em.setImg(rs.getString("img"));
                    em.setDescripcion(rs.getString("descripcion"));

                    Categoria c = new Categoria();
                    c.setId(rs.getLong("cm.id"));
                    c.setCategoria(rs.getString("categoria"));
                    em.setCategoria(c);
                    dp.setElementoMenu(em);

                    detallePedidosPorIdOrden.add(dp);
                }
            }
        } catch (SQLException e) {

        }
        return detallePedidosPorIdOrden;
    }
}
