package com;

import java.time.LocalDate;

import com.ejemplo.Reserva;

public interface PoliticaCancelacion {

    public double calcularReembolso(double precio, LocalDate hoy, Reserva reserva);
    
}
