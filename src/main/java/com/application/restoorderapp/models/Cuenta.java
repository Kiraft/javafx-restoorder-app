package com.application.restoorderapp.models;

public class Cuenta {
    Long id;
    String usuario;
    String password;
    Empleado empleado;

    public Cuenta() {
    }

    public Cuenta(Long id, String usuario, String password, Empleado empleado) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.empleado = empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
