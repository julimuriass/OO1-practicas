package ejercicio13.src.main.java.com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private String nombre;
    private List<Inversion>inversiones;

    public double calcularValorTotal() {

        return this.inversiones.stream().mapToDouble(inversion -> inversion.calcularValor()).sum();
    }

    public List<Inversion> getInversiones() {
        return this.inversiones;
    }

    private List<AccionInversion> getAccionInversiones() {
        List<AccionInversion> acciones = new ArrayList<>();
        this.inversiones.stream()
            .filter(inv -> inv instanceof AccionInversion)
            .forEach(inv -> {
                AccionInversion accion = (AccionInversion) inv;
                acciones.add(accion);

            });

        return acciones;
    }

    private List<PlazoFijo> getPlazosFijos() {
        List<PlazoFijo> plazos = new ArrayList<>();
        this.inversiones.stream()
            .filter(inv -> inv instanceof PlazoFijo)
            .forEach(inv -> {
                PlazoFijo plazo = (PlazoFijo) inv;
                plazos.add(plazo);

            });
            
        return plazos;
    }
}
