package com.application.restoorderapp.models;

public class TipoEmpleado {
    Long id;
    String tipo;

    public TipoEmpleado() {

    }

    public TipoEmpleado(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
