package com.application.restoorderapp.models;

public class TipoEmpleado {
    Integer id;
    String tipo;

    public TipoEmpleado() {

    }

    public TipoEmpleado(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoEmpleado{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
