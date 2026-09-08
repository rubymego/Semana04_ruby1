package com.example.consulta_productos_rest;

import com.google.gson.annotations.SerializedName;

public class Producto {
    private int id;
    
    @SerializedName("title")
    private String nombre;
    
    private double price;
    
    private String category;

    public Producto(int id, String nombre, double price, String category) {
        this.id = id;
        this.nombre = nombre;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
