package com.ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.management.PlatformLoggingMXBean;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
    private Inversor inversor;


    @BeforeEach
    void setUp() {
        this.inversor = new Inversor("Julio 9");
    }

    @Test
    void testConstructor(){
        assertFalse(this.inversor.getInversiones() == null);
    }

    @Test
    void testAgregarAccion(){
        AccionInversion accion1 = new AccionInversion("macana", 3, 10);
        AccionInversion accion2 = new AccionInversion("macana", 2, 10);
        AccionInversion accion3 = new AccionInversion("pedo", 3, 20);




        this.inversor.agregarAccion(accion1);
        this.inversor.agregarAccion(accion3);

        assertTrue(this.inversor.getInversiones().size() == 2);

        this.inversor.agregarAccion(accion2);

        assertTrue(this.inversor.getInversiones().size() == 2);
        
        AccionInversion accion = this.inversor.getAccionInversion("macana");
        assertTrue(accion.getCantidad() == 5);
    }
    

    @Test
    void testAgregarPlazoFijo(){
        Date fecha1 = new Date(2025, 10, 10);
        PlazoFijo plazo = new PlazoFijo(fecha1, 1000, 50);
        this.inversor.agregarPlazoFijo(plazo);
        assertTrue(this.inversor.getInversiones().size()==1);
        

    }
}
