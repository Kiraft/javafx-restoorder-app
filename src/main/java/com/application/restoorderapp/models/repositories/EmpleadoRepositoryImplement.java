package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.Empleado;
import com.application.restoorderapp.models.interfaces.Repository;

import java.util.List;

public class EmpleadoRepositoryImplement implements Repository<Empleado> {
    @Override
    public List<Empleado> listar() {
        return null;
    }

    @Override
    public Empleado porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Empleado alumno) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
