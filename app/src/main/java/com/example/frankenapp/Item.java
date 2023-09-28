package com.example.frankenapp;

public class Item {
    private float estrellas;
    private String titulo;

    public Item(float estrellas, String titulo) {
        this.estrellas = estrellas;
        this.titulo = titulo;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
