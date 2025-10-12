package com.ejemplo;


public abstract class Cuenta {
	private double saldo;
	
	public Cuenta() {
		this.saldo = 0;
	}

	public Cuenta(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	protected void extraerSinControlar(double monto) {
		double montoAExtraer = this.calcularMontoAExtraer(monto);
		this.saldo -= montoAExtraer;
	}

	protected abstract double calcularMontoAExtraer(double monto);
	
	public void depositar(double monto) {
		if (monto > 0) {
			this.saldo += monto;
		}
	}
	
	public abstract boolean puedeExtraer(double monto);

	public boolean transferirACuenta(Cuenta cuentaDestino, double monto) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		
		return false;
	}
	
	public boolean extraer(double monto) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
}