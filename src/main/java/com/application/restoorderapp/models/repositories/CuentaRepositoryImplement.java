package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.interfaces.Repository;

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
}
