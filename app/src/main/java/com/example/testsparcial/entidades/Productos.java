package com.example.testsparcial.entidades;

public class Productos {

    private int id;
    private String nombre;
    private String cantidad;
    ;

    public int getId() { //encapsulamiento
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCanttidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantidad() { return cantidad; }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


}

