package com.application.restoorderapp.models;

public class Empleado {
    Long id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String rfc;
    String email;
    String code;

    Boolean has_account;

    TipoEmpleado tipoEmpleado;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String email, String code, Boolean has_account, TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.email = email;
        this.code = code;
        this.has_account = has_account;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Boolean getHas_account() {
        return has_account;
    }

    public void setHas_account(Boolean has_account) {
        this.has_account = has_account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", rfc='" + rfc + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", has_account=" + has_account +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }
}
