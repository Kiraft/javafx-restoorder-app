package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Categoria;
import com.application.restoorderapp.models.interfaces.Repository;

import java.util.List;

public class CategoriaRepositoryImplement implements Repository<Categoria> {

    @Override
    public List<Categoria> listar() {
        return null;
    }

    @Override
    public Categoria porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Categoria alumno) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
