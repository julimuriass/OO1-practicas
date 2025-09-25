package com.ejemplo;

public abstract class Cuerpo3D { 
    private Figuras2d cuerpo; //Cuerpo va a ser de cualquier clase que implemente esta interfaz.
    private double altura;

    public Cuerpo3D() {
        this.altura = 1;
    }

    //Setters.
    public abstract void setAltura(double altura);

    

    public abstract void setCaraBasal(Figuras2d figura);

    //Getters.

   // El área o superficie exterior de un cuerpo es:  2* área-cara-basal + perímetro-cara-basal * altura-del-cuerpo
  //El volumen de un cuerpo es: área-cara-basal * altura

    double getSuperficieExterior() {
        return 2 * this.cuerpo.getArea() + this.cuerpo.getPerimetro() * this.altura;
    }

    double getVolumen() {
        return this.cuerpo.getArea() * this.altura;
    }

    double getAltura() {
        return this.altura;
    }


}
