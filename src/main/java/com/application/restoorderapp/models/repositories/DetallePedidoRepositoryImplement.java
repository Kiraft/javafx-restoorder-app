package com.application.restoorderapp.models.repositories;

import com.application.restoorderapp.models.DetallePedido;
import com.application.restoorderapp.models.interfaces.Repository;

import java.util.List;

public class DetallePedidoRepositoryImplement implements Repository<DetallePedido> {
    @Override
    public List<DetallePedido> listar() {
        return null;
    }

    @Override
    public DetallePedido porId(Long id) {
        return null;
    }

    @Override
    public void guardar(DetallePedido alumno) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
