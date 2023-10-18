package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.TipoEmpleado;
import com.application.restoorderapp.models.interfaces.Repository;

import java.util.List;

public class TipoEmpleadoRepositoryImplement implements Repository<TipoEmpleado> {

    @Override
    public List<TipoEmpleado> listar() {
        return null;
    }

    @Override
    public TipoEmpleado porId(Long id) {
        return null;
    }

    @Override
    public void guardar(TipoEmpleado alumno) {

    }


    @Override
    public void eliminar(Long id) {

    }
}
