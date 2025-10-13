package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccionInversionTest {
    private AccionInversion accionInversion;


    @BeforeEach
    void setUp(){
            this.accionInversion= new AccionInversion("macana", 30, 1);
    }

    @Test
    void testConstructor(){
        assertTrue(this.accionInversion.getCantidad()==30);
    }

    @Test
    void testCalcularValor(){
        assertTrue(this.accionInversion.calcularValor()==30);
    }

    @Test
    void testAumentarCantidad(){
        this.accionInversion.aumentarCantidad(30);
        assertTrue(this.accionInversion.getCantidad()==60);
    }
    
}
