package com.ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Inmueble {
    private String direccion;
    private String name;
    private double precio;
    private List<Reserva> historialReserva;

    public Inmueble(String direccion, String name, double precio) {
        this.direccion = direccion;
        this.name = name;
        this.precio = precio;

        this.historialReserva = new ArrayList<>();

    }

    public String getNombre() {
        return this.name;
    }

    public boolean consultarDisponibilidad(LocalDate from, LocalDate to) {

        //Recorro el historial de reservas preguntando por fechas.
        DateLapse fecha = new DateLapse(from, to);
                                                                //Delego a reserva.
        return this.historialReserva.stream().anyMatch(reserva -> reserva.consultarDisponibilidad(fecha));
    }
    

    public void agregarReserva(Reserva reserva) {
        this.historialReserva.add(reserva);
    }

    public double calcularPrecio(Reserva reserva) {
        Reserva reserv = this.historialReserva.stream().filter(hr -> hr.equals(reserva)).findAny().orElse(null);

        return reserv.calcularPrecio(this.precio);
    }

    public void eliminarReserva(Reserva reserva) {
        this.historialReserva.remove(reserva);
    }

    public double calcularPrecioEntreLimite(LocalDate from, LocalDate to) {
        List<Reserva> reservasApropiadas = this.historialReserva.stream().filter(reserv -> reserv.includesDate(from) && reserv.includesDate(to)).collect(Collectors.toList());

        if (reservasApropiadas.isEmpty()) return 0.0;

        return reservasApropiadas.stream().mapToDouble(ra -> ra.calcularPrecio(this.precio)).sum();
    }
}

