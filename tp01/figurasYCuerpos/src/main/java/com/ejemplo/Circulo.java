package com.ejemplo;

public class Circulo {
    private double radio; 
    private double diametro;

    public Circulo() {
        this.radio = 0;
        this.diametro = 0;
    }

    //Setters.
    /*void setDiametro (double radio) {
        this.diametro = radio*2;
    }*/

    void setRadio(double radio) {
        this.radio = radio;
    }


    //Getters.
    double getDiametro() {
        return this.radio * 2;
    }

    double getRadio() {
        return this.radio;
    }

    double getPerimetro() {
        return Math.PI * this.getDiametro();
    }

    double getArea() {
        return Math.PI * (this.radio * this.radio);
    }

}
