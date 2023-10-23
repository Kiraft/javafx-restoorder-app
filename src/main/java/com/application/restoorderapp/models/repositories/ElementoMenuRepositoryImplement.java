package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.ElementoMenu;
import com.application.restoorderapp.models.interfaces.Repository;

import java.util.List;

public class ElementoMenuRepositoryImplement implements Repository<ElementoMenu> {
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
}
