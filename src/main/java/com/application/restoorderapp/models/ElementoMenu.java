package com.application.restoorderapp.models;

public class ElementoMenu {
    Long id;
    String nombre;
    Double precio;
    Categoria categoria;
    String img;

    String descripcion;

    public ElementoMenu() {
    }

    public ElementoMenu(Long id, String nombre, Double precio, Categoria categoria, String img, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.img = img;
        this.descripcion = descripcion;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ElementoMenu{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                ", img='" + img + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
