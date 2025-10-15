package com.ejemplo;

public class Esfera {
    private double radio;

    public double getRadio() {
        return this.radio;
    }

    public double getVolumen() {
        return (4/3) * Math.PI * this.getRadio() * this.getRadio() * this.getRadio();
    }

    public double getSuperficie() {
        return 4 * Math.PI * this.getRadio() * this.getRadio();
    }
    
}
