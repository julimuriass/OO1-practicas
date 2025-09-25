package figurasYCuerpos.src.main.java.com.ejemplo;

public class Circulo {
    private double radio; //Está bien ponerle el private??? cuándo sé qué ponerle?
    private double diametro;

    //Cuándo sé que los setters/getters deben ser privados o publicos??
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
