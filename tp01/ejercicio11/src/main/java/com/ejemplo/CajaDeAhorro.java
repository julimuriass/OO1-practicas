package com.ejemplo;

public class CajaDeAhorro extends Cuenta {
	
	public CajaDeAhorro() {
		super();
	}

	public CajaDeAhorro(double saldo) {
		super(saldo);
	}

	protected double calcularMontoAExtraer(double monto) {
		return monto * 1.02;
	}
	
	public boolean puedeExtraer(double monto) {
		if(this.getSaldo()>= (monto * 1.02)) {
			return true;
		}
		return false;
	}
	
	

}
