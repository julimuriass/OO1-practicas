package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CuentaCorrienteTest {
    private CuentaCorriente cuentaCorriente;
    private CuentaCorriente cuentaCorriente2;
    private CajaDeAhorro cajaDeAhorro;
    

    @BeforeEach
    void setUp() {
        this.cajaDeAhorro = new CajaDeAhorro();
        this.cuentaCorriente = new CuentaCorriente(1000, 500);
        this.cuentaCorriente2 = new CuentaCorriente(); //saldo 0, límite 0.
    }

    @Test 
    void testConstructor() {
        assertTrue(cuentaCorriente.getSaldo() == 1000);
        assertTrue(cuentaCorriente.getLimite() == 500);

        assertTrue(cuentaCorriente2.getSaldo() == 0);
        assertTrue(cuentaCorriente2.getLimite() == 0);
    }

    @Test
	void testPuedeExtraer() {
		assertTrue(cuentaCorriente.puedeExtraer(100));
		assertTrue(cuentaCorriente.puedeExtraer(1500)); //Caso límite

        assertFalse(cuentaCorriente.puedeExtraer(1600)); //No puede.
	}

    @Test
	void testDepositar() {
		cuentaCorriente.depositar(100); 
		assertTrue(cuentaCorriente.getSaldo() == 1100);

		cuentaCorriente.depositar(-100); //No se tendría que depositar un saldo negativo.
		assertTrue(cuentaCorriente.getSaldo() == 1100);
	}

    @Test
	void testExtraerSinControlar() {
		cuentaCorriente.extraerSinControlar(500);
		assertTrue(cuentaCorriente.getSaldo() == 500);

		cuentaCorriente.extraerSinControlar(600);
		assertTrue(cuentaCorriente.getSaldo() == -100);
	}

    @Test 
	void testEstraer() {
		assertTrue(cuentaCorriente.extraer(100));
		assertTrue(cuentaCorriente.getSaldo() == 900);

		assertFalse(cuentaCorriente.extraer(1600));
	}

    @Test
    void testTransferirACuenta() {
        //De cuenta corriente a cuenta corriente.
        assertTrue(cuentaCorriente.transferirACuenta(cuentaCorriente2, 500));
        assertTrue(cuentaCorriente.getSaldo() == 500);
        assertTrue(cuentaCorriente2.getSaldo() == 500);

        assertFalse(cuentaCorriente.transferirACuenta(cuentaCorriente2, 1100));

        //De cuenta corriente a caja de ahorro.
        assertTrue(cuentaCorriente.transferirACuenta(cajaDeAhorro, 200));
    }

	
}
