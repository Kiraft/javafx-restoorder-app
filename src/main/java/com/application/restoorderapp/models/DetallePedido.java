package com.application.restoorderapp.models;

public class DetallePedido {

    Long id;
    Integer cantidad;
    Double precio_unitario;
    Double precio_total;
    Orden orden;

    ElementoMenu elementoMenu;
    String comentario;

    public DetallePedido() {
    }

    public DetallePedido(Long id, Integer cantidad, Double precio_unitario, Double precio_total, Orden orden, ElementoMenu elementoMenu) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.precio_total = precio_total;
        this.orden = orden;
        this.elementoMenu = elementoMenu;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Double precio_total) {
        this.precio_total = precio_total;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public ElementoMenu getElementoMenu() {
        return elementoMenu;
    }

    public void setElementoMenu(ElementoMenu elementoMenu) {
        this.elementoMenu = elementoMenu;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", precio_total=" + precio_total +
                ", orden=" + orden +
                ", elementoMenu=" + elementoMenu +
                '}';
    }
}
