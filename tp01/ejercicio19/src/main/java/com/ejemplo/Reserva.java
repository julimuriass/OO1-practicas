package ejercicio19.src.main.java.com.ejemplo;

import java.time.LocalDate;

public class Reserva extends DateLapse{
    private Usuario cliente; //Desde el punto de vista de usuario es al pe2 tener esto. !!!!!!!!!!!!!!!!!!!!
    private Inmueble propiedad; //Same here.

    //Esas dudas me llevan a pensar si tendría que tener un constructor distinto para cada caso, en uno recibo (además de la fecha) el dueño, y en otro el inmueble???????


    public Reserva (Usuario cliente, Inmueble inmueble, LocalDate from, LocalDate to) {
        super(from, to);
        this.cliente = cliente;
        this.propiedad = inmueble;
    }

    public boolean consultarDisponibilidad(DateLapse fecha) {
        return super.overlaps(fecha); 
    }

    public Inmueble getInmueble() {
        return this.propiedad;
    }

    public Usuario getUsuario() {
        return this.cliente;
    }

    public double calcularPrecio(double precio) {
        return precio * super.sizeInDays();
    }






    
}
