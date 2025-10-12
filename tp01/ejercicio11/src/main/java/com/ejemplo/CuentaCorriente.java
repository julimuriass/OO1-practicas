package com.ejemplo;


public class CuentaCorriente extends Cuenta {
	private double limiteDescubierto;
	
	public CuentaCorriente() {
		super();
		this.limiteDescubierto = 0;
	}
	
	public CuentaCorriente(double limite) {
		super();
		this.limiteDescubierto = limite;
	}
	

	protected double calcularMontoAExtraer(double monto) {
		return monto;
	}

	public void setLimiteDescubierto(double limite) {
		this.limiteDescubierto = limite;
	}
	
	public boolean puedeExtraer(double monto) {
		if((this.getSaldo()>= monto) || (monto -this.getSaldo() >= this.limiteDescubierto)) {
			return true;
		}
		return false;
	}

}