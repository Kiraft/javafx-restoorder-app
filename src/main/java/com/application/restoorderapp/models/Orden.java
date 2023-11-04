package com.application.restoorderapp.models;

import java.util.Date;

public class Orden {
    Long id;
    Date fecha;
    String estado_preparacion;

    Empleado empleado;

    public Orden() {
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado_preparacion='" + estado_preparacion + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
