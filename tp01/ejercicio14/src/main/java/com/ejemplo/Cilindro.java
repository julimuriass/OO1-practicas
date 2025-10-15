package com.ejemplo;

public class Cilindro extends Pieza{
    private double radio;
    private double altura;

    public double getVolumen(){
        return Math.PI * this.getRadio() * this.getRadio() * this.getAltura();
    }

    public double getSuperficie(){
        return 2 * Math.PI * this.getRadio() * this.getAltura() + 2 * Math.PI * this.getRadio() * this.getRadio();
    }
    
    public double getRadio() {
        return this.radio;
    }

    public double getAltura() {
        return this.altura;
    }
}
