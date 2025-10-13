package ejercicio14.src.main.java.com.ejemplo;

public abstract class Pieza {
    private String color;
    private String material; 

    public  abstract double getVolumen();

    public abstract double getSuperficie();

    public String getColor() {
        return this.color;
    }

    public String getMaterial() {
        return this.material;
    }

}
