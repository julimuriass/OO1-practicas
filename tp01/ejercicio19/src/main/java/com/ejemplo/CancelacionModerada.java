package com.ejemplo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.PoliticaCancelacion;

public class CancelacionModerada implements PoliticaCancelacion{


    public double calcularReembolso(double precio, LocalDate hoy, Reserva reserva) {
        //reembolsa el monto total si la cancelación se hace hasta una semana antes y 50% si se hace hasta 2 días antes.
        
        long diferenciaDias = ChronoUnit.DAYS.between(hoy, reserva.getFrom()); 
        if (diferenciaDias >= 7) {
            return precio * reserva.calcularPrecio();
        } else {
            if (diferenciaDias <= 2) {
                return (precio * reserva.calcularPrecio())/2;
            }
        }
         
        return 0.0;
    }

    
    
}
