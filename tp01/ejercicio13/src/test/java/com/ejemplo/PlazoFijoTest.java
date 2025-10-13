package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlazoFijoTest {
    private PlazoFijo plazoFijo;

    @BeforeEach
    void setUp() {
        Date fecha1 = new Date(2025, 10, 10);
        plazoFijo = new PlazoFijo(fecha1, 1000, 50);
    }

    @Test
    void testConstructor() {
        assertTrue(this.plazoFijo.getValorInicial() == 1000);
    }

   @Test 
   void testCalcularValor() {
        assertTrue(this.plazoFijo.calcularValor() == 1150);
   }

    
}
