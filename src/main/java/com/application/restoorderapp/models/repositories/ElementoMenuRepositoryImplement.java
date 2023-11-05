package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Categoria;
import com.application.restoorderapp.models.ElementoMenu;
import com.application.restoorderapp.models.interfaces.Repository;
import com.application.restoorderapp.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElementoMenuRepositoryImplement implements Repository<ElementoMenu> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    @Override
    public List<ElementoMenu> listar() {
        return null;
    }

    @Override
    public ElementoMenu porId(Long id) {
        return null;
    }

    @Override
    public void guardar(ElementoMenu alumno) {

    }

    @Override
    public void eliminar(Long id) {

    }

    public List<ElementoMenu> listarPorCategoria(String categoria) {

        List<ElementoMenu> elementos = new ArrayList<>();

        try (PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM elementos_menu as em INNER JOIN categorias_menu as cm ON (em.categorias_menu_id = cm.id) WHERE cm.categoria = ?;")) {

            pst.setString(1, categoria);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    ElementoMenu em = new ElementoMenu();
                    em.setId(rs.getLong("id"));
                    em.setNombre(rs.getString("nombre"));
                    em.setPrecio(rs.getDouble("precio"));

                    Categoria c = new Categoria();
                    c.setId(rs.getLong("id"));
                    c.setCategoria(rs.getString("categoria"));
                    em.setCategoria(c);

                    em.setImg(rs.getString("img"));
                    elementos.add(em);
                }
            }
        } catch (SQLException e) {

        }

        return elementos;
    }

    public List<ElementoMenu> listarPorIdOrden(String categoria) {

        List<ElementoMenu> elementos = new ArrayList<>();

        try (PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM elementos_menu as em INNER JOIN categorias_menu as cm ON (em.categorias_menu_id = cm.id) WHERE cm.categoria = ?;")) {

            pst.setString(1, categoria);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    ElementoMenu em = new ElementoMenu();
                    em.setId(rs.getLong("id"));
                    em.setNombre(rs.getString("nombre"));
                    em.setPrecio(rs.getDouble("precio"));

                    Categoria c = new Categoria();
                    c.setId(rs.getLong("id"));
                    c.setCategoria(rs.getString("categoria"));
                    em.setCategoria(c);

                    em.setImg(rs.getString("img"));
                    elementos.add(em);
                }
            }
        } catch (SQLException e) {

        }

        return elementos;
    }

}
