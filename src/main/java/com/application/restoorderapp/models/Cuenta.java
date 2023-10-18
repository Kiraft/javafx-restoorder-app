package com.application.restoorderapp.models;

public class Cuenta {
    Integer id;
    String usuario;
    String password;
    Empleado empleado;

    public Cuenta() {
    }

    public Cuenta(Integer id, String usuario, String password, Empleado empleado) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.empleado = empleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
