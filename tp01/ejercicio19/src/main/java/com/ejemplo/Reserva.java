package com.ejemplo;

import java.time.LocalDate;

public class Reserva extends DateLapse{ 
    private Usuario cliente; 
    private Inmueble propiedad; 
    private DateLapse fecha;

    public Reserva (Usuario cliente, Inmueble inmueble, LocalDate from, LocalDate to) {
        super(from, to);
        this.cliente = cliente;
        this.propiedad = inmueble;
        this.fecha = new DateLapse(from, to);
    }

    public boolean consultarDisponibilidad(DateLapse fecha) {
        return this.fecha.overlaps(fecha); 
    }

    public int calcularPrecio() { 
        return this.fecha.sizeInDays();
    }
}
