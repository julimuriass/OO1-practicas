package com.ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private int dni;
    private List<Inmueble> propiedades;
    private List<Reserva> reservas;


    public Usuario(String nombre, String direccion, int dni){
        this.direccion = direccion;
        this.dni = dni;
        this.nombre = nombre;

        this.propiedades = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public int getDni() {
        return this.dni;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public double calcularIngresoPropietario(LocalDate from, LocalDate to) {
        if (propiedades.isEmpty()) return 0.0;

        double sumaTotal = this.propiedades.stream().mapToDouble(prop -> prop.calcularPrecioEntreLimite(from, to)).sum();

        return sumaTotal * 0.75;
    }


}
