package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import ejercicio11.src.main.java.com.ejemplo.CajaDeAhorro;
//import ejercicio11.src.main.java.com.ejemplo.CuentaCorriente;


public class CajaDeAhorroTest {
    private CuentaCorriente cuentaCorriente;
    private CajaDeAhorro cajaDeAhorro;
	private CajaDeAhorro cajaDeAhorro2;

    @BeforeEach
	void setUp() throws Exception {
		this.cuentaCorriente = new CuentaCorriente();
		this.cajaDeAhorro = new CajaDeAhorro(1000);
		this.cajaDeAhorro2 = new CajaDeAhorro();
	}

	@Test
	void testConstructor() {
		assertTrue(cajaDeAhorro.getSaldo() == 1000);
		assertTrue(cajaDeAhorro2.getSaldo() == 0);
	}

	@Test
	void testPuedeExtraer() {
		assertTrue(cajaDeAhorro.puedeExtraer(100));
		assertFalse(cajaDeAhorro.puedeExtraer(1000)); //No puede extraer.
	}

	@Test
	void testDepositar() {
		cajaDeAhorro.depositar(100); 
		assertTrue(cajaDeAhorro.getSaldo() == 1100);

		cajaDeAhorro.depositar(-100); //No se tendría que depositar un saldo negativo.
		assertTrue(cajaDeAhorro.getSaldo() == 1100);
	}

	@Test
	void testExtraerSinControlar() {
		cajaDeAhorro.extraerSinControlar(500);
		assertTrue(cajaDeAhorro.getSaldo() == 500);

		cajaDeAhorro.extraerSinControlar(600);
		assertTrue(cajaDeAhorro.getSaldo() == -100);
	}

	@Test 
	void testEstraer() {
		assertTrue(cajaDeAhorro.extraer(100));
		assertTrue(cajaDeAhorro.getSaldo() == 898);

		assertFalse(cajaDeAhorro.extraer(1000));
	}

	@Test 
	void testTransferirACuenta() {
		//De caja de ahorro a caja de ahorro
		assertTrue(cajaDeAhorro.transferirACuenta(cajaDeAhorro2, 500));
		assertTrue(cajaDeAhorro.getSaldo() == 490);
		assertTrue(cajaDeAhorro2.getSaldo() == 500);

		assertFalse(cajaDeAhorro.transferirACuenta(cajaDeAhorro2, 1000));

		//De caja de ahorro a cuenta corriente.
		assertTrue(cajaDeAhorro.transferirACuenta(cuentaCorriente, 100));
		assertTrue(cajaDeAhorro.getSaldo() == 388);
		assertTrue(cuentaCorriente.getSaldo() == 100);
	}




    
}
