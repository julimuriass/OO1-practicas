package com.ejemplo;

import java.time.LocalDate;

import com.PoliticaCancelacion;

public class CancelacionEstricta implements PoliticaCancelacion {
    //no reembolsará nada (0, cero) sin importar la fecha tentativa de cancelación. 
    
    public double calcularReembolso(double precio, LocalDate hoy, Reserva reserva) {
        return 0.0;
    }

}
