package ejercicio13.src.main.java.com.ejemplo;

import java.util.List;

public class AccionInversion {
    private String nombre;
    private double cantidad;
    private double valorUnitario;
    

    public AccionInversion(String nombre, double cantidad, double valorUnitario) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    
    public double calcularValor() {
        return this.cantidad * this.valorUnitario;
    }
}
