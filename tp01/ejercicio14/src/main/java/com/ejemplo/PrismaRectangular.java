package ejercicio14.src.main.java.com.ejemplo;

public class PrismaRectangular {
    private double ladoMayor;
    private double ladoMenor;
    private double altura;

    public double getAltura() {
        return this.altura;
    }

    public double getLadoMenor() {
        return this.ladoMenor;
    }

    public double getLadoMayor() {
        return this.ladoMayor;
    }

    public double getSuperficie() {
        return 2 * (this.getLadoMayor() * this.getLadoMenor() + this.getLadoMayor() * this.getAltura() + this.getLadoMenor() * this.getAltura());
    }
    

    public double getVolumen() {
        return this.getLadoMayor() * this.getLadoMenor() * this.getAltura();
    }
    
}
