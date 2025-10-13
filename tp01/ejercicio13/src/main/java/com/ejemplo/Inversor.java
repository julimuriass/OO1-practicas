package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private String nombre;
    private List<Inversion> inversiones;

    public Inversor(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public double calcularValorTotal() {

        return this.inversiones.stream().mapToDouble(inversion -> inversion.calcularValor()).sum();
    }

    public List<Inversion> getInversiones() {
        return this.inversiones;
    }

    /*
     * Test
     * void testAgregarinversion() {
     *      assertTrue (inversor.getInversiones.size() == tamviejo) 
     *  
     *      this.inversor.agregarinversion() 
     *      assertTrue (inversor.getInversiones.size() == tamnuevo)     *      
     * }
     * 
     * 
     */

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

    public AccionInversion getAccionInversion(String nombre){
        List<AccionInversion> acciones = this.getAccionInversiones();
        return acciones.stream().filter(a -> a.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public void agregarAccion(AccionInversion accion){
        List<AccionInversion> acciones = this.getAccionInversiones();

        acciones.stream().filter(a -> a.getNombre().equals(accion.getNombre())).findFirst().ifPresentOrElse( a -> a.aumentarCantidad(accion.getCantidad()),
        () -> this.inversiones.add(accion));
    }


    public void agregarPlazoFijo(PlazoFijo plazo) {
        this.inversiones.add(plazo); 
    }

    public void eliminarAccion(AccionInversion accion) {
        List<AccionInversion> acciones = this.getAccionInversiones();

        acciones.stream().filter(a -> a.getNombre().equals(accion.getNombre())).findFirst().ifPresent(a -> this.inversiones.remove(accion));
    }

    public void eliminarPlazo(PlazoFijo plazo) {
        this.inversiones.remove(plazo);
    }
}
