package figurasYCuerpos.src.main.java.com.ejemplo;

public class Figuras3d {
    private Figuras2d cuerpo; //Cuerpo va a ser de cualquier clase que implemente esta interfaz.
    private double altura;


    //Setters.
    void setAltura(double altura) {
        this.altura = altura;
    }

    void setCaraBasal(Figuras2d figura) {
        this.cuerpo = figura;
    }

    //Getters.

   // El área o superficie exterior de un cuerpo es:  2* área-cara-basal + perímetro-cara-basal * altura-del-cuerpo
  //El volumen de un cuerpo es: área-cara-basal * altura

    double getArea() {
        return 2 * this.cuerpo.getArea() + this.cuerpo.getPerimetro() * this.altura;
    }

    double getVolumen() {
        return this.cuerpo.getArea() * this.altura;
    }
}
