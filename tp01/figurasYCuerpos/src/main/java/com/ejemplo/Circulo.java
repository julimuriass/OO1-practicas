package figurasYCuerpos.src.main.java.com.ejemplo;

public class Circulo {
    private double radio; 
    private double diametro;

    //Setters.
    void setDiametro (double radio) {
        this.diametro = radio*2;
    }

    void setRadio(double radio) {
        this.radio = radio;
    }


    //Getters.
    double getDiametro() {
        return this.diametro;
    }

    double getRadio() {
        return this.radio;
    }

    double getPerimetro() {
        return Math.PI * this.diametro;
    }

    double getArea() {
        return Math.PI * (this.radio * this.radio);
    }

}
