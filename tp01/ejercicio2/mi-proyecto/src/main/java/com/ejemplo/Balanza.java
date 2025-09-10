package com.ejemplo;
import java.time.Instant;
import java.util.Date;

public class Balanza {
    Integer cantDeProductos = 0;
    double precioTotal;
    double pesoTotal;

    //Pone en cero todos los valores de la balanza.
    void ponerEnCero() {
        this.cantDeProductos = 0;
        this.pesoTotal = 0;
        this.precioTotal = 0;
    }

    //Agrega producto a la balanza (modificando cantidad de productos, el precio y el peso total).
    void agregarProducto (Producto producto) {
        this.cantDeProductos += 1;
        this.precioTotal += producto.getPrecio();
        this.pesoTotal += producto.getPeso();
    }

    Ticket emitirTicket() {
        Instant now = Instant.now();
        Date date = Date.from(now); //Preg if okay la forma en la que declaré la fecha.
        Ticket ticket = new Ticket(date, this.cantDeProductos, this.precioTotal, this.pesoTotal);
        return ticket;
    }

    //Getters.

    public double getPesoTotal() {
        return this.pesoTotal;
    }

    public double getPrecioTotal() {
        return this.precioTotal;
    }

    public Integer getCantidadDeProductos() {
        return this.cantDeProductos;
    }
}
