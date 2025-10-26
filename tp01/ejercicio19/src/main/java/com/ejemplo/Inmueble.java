package com.ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.PoliticaCancelacion;

public class Inmueble {
    private String direccion;
    private String name;
    private double precio;
    private List<Reserva> historialReserva;
    private PoliticaCancelacion politicaCancelacion;

    public Inmueble(String direccion, String name, double precio, PoliticaCancelacion politicaCancelacion) {
        this.direccion = direccion;
        this.name = name;
        this.precio = precio;
        this.politicaCancelacion = politicaCancelacion;

        this.historialReserva = new ArrayList<>();

    }

    public double calcularReembolso(double precio, Reserva reserva) {
        return this.politicaCancelacion.calcularReembolso(precio, LocalDate.now(), reserva);
    }

    public double calcularPrecio(Reserva reserva) {
        //Verificar si existe la reserva.
        if (!this.historialReserva.contains(reserva)) return 0.0;
        return this.precio * reserva.calcularPrecio();
    }

    public void agregarReserva(Reserva reserva) {
        this.historialReserva.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        this.historialReserva.remove(reserva);
    }

    public double calcularPrecioEntreLimite(LocalDate from, LocalDate to) {
        List<Reserva> reservasApropiadas = this.historialReserva.stream().filter(reserv -> reserv.includesDate(from) && reserv.includesDate(to)).collect(Collectors.toList());

        if (reservasApropiadas.isEmpty()) return 0.0;

        return reservasApropiadas.stream().mapToDouble(ra -> ra.calcularPrecio()).sum();
    }

    public boolean consultarDisponibilidad(LocalDate from, LocalDate to) {

        //Recorro el historial de reservas preguntando por fechas.
        DateLapse fecha = new DateLapse(from, to);
                                                                //Delego a reserva.
        return this.historialReserva.stream().anyMatch(reserva -> reserva.consultarDisponibilidad(fecha));
    }


    public boolean crearReserva(Usuario usuario, LocalDate from, LocalDate to) {
        //Consulto disponibilidad.
        if (!this.consultarDisponibilidad(from, to)) return false;

        //Crear reserva.
        Reserva reserva = new Reserva(usuario, this, from, to);

        this.agregarReserva(reserva);

        return true;
    }

    public boolean cancelarReserva(Reserva reserva) {
        if (reserva.includesDate(LocalDate.now())) return false;

        //Buscar en el historial de reservas (contains)
        //Asumo que la reserva existe, no sé.
        this.historialReserva.remove(reserva);

        return true;
    }
}

