package com.application.restoorderapp.models;

public class Mesa {
    Long id;

    Boolean status;
    Integer capacidad;

    public Mesa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", status=" + status +
                ", capacidad=" + capacidad +
                '}';
    }
}
