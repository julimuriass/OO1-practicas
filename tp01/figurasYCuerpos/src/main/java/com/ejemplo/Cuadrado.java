package com.ejemplo;

public class Cuadrado implements Figuras2d {
    private double lado;

    public Cuadrado() {
        this.lado = 1;
    }

    //Setters.
    void setLado(double lado) {
        this.lado = lado;
    }
    //Getters.

    double getLado() {
        return this.lado;
    }

    public double getPerimetro() {
        return this.lado * 4;
    }

    public double getArea() {
        return this.lado * this.lado;
    }
}
