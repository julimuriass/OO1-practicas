package ejercicio13.src.main.java.com.ejemplo;

import java.util.Date;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class PlazoFijo implements Inversion {
    private Date fecha;
    private double valorInicial;
    private double interes;

    public PlazoFijo(Date fecha, double valorInicial, double interes) {
        this.fecha = fecha;
        this.valorInicial = valorInicial;
        this.interes = interes;
    }

    public double calcularValor() {
        Date hoy = new Date();
        long diferenciaMs = hoy.getTime() - fecha.getTime();
        int dias= (int) (diferenciaMs / (1000 * 60 * 60 * 24));

        return dias * interes + valorInicial;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public double getValorInicial() {
        return this.valorInicial;
    }

    public double interes() {
        return interes;
    }
}
