package com.application.restoorderapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orden {
    Long id;
    Date fecha;
    String estado_preparacion;
    String cliente;

    Empleado empleado;
    Boolean done;

    Mesa mesa;

    List<DetallePedido> detallePedidos;

    public Orden() {
        detallePedidos = new ArrayList<>();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado_preparacion() {
        return estado_preparacion;
    }

    public void setEstado_preparacion(String estado_preparacion) {
        this.estado_preparacion = estado_preparacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado_preparacion='" + estado_preparacion + '\'' +
                ", cliente='" + cliente + '\'' +
                ", empleado=" + empleado +
                ", done=" + done +
                ", detallePedidos=" + detallePedidos +
                '}';
    }
}
