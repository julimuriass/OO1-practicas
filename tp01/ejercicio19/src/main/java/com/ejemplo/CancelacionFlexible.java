package com.ejemplo;

import java.time.LocalDate;
import java.util.Date;

import com.PoliticaCancelacion;

public class CancelacionFlexible implements PoliticaCancelacion {
    //reembolsa el monto total sin importar la fecha de cancelación (que de todas maneras debe ser anterior a la fecha de inicio de la reserva). 

    public double calcularReembolso(double precio, LocalDate hoy, Reserva reserva) {
        if (reserva.getFrom().isAfter(hoy)) {
            return precio * reserva.calcularPrecio();
        }

        return 0.0;
    }

}
