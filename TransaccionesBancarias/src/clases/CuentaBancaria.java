package clases;

import java.util.Date;

import utileria.AdminFechas;

public abstract class CuentaBancaria {
	
	private Usuario _titular;
	private Date _fechaDeApertura = AdminFechas.getFechaActual();
	private String _nombreTipoCuenta;
	private int _numeroCuenta;
	
	public CuentaBancaria() {
		super();
	}

	public CuentaBancaria(Usuario _titular, Date _fechaDeApertura, String _nombreTipoCuenta, int _numeroCuenta) {
		super();
		this._titular = _titular;
		this._fechaDeApertura = _fechaDeApertura;
		this._nombreTipoCuenta = _nombreTipoCuenta;
		this._numeroCuenta = _numeroCuenta;
	}

	public Usuario get_titular() {
		return _titular;
	}



	public void set_titular(Usuario _titular) {
		this._titular = _titular;
	}



	public Date get_fechaDeApertura() {
		return _fechaDeApertura;
	}



	public void set_fechaDeApertura(Date _fechaDeApertura) {
		this._fechaDeApertura = _fechaDeApertura;
	}



	public String get_nombreTipoCuenta() {
		return _nombreTipoCuenta;
	}



	public void set_nombreTipoCuenta(String _nombreTipoCuenta) {
		this._nombreTipoCuenta = _nombreTipoCuenta;
	}



	public int get_numeroCuenta() {
		return _numeroCuenta;
	}



	public void set_numeroCuenta(int _numeroCuenta) {
		this._numeroCuenta = _numeroCuenta;
	}



	@Override
	public String toString() {
		/*
		return "CuentaBancaria [_titular=" + _titular + ", _fechaDeApertura=" + _fechaDeApertura
				+ ", _nombreTipoCuenta=" + _nombreTipoCuenta + ", _numeroCuenta=" + _numeroCuenta + "]";
		*/
		String _infoCuentaBancaria = String.format("\nCUENTA BANCARIA:\n--------------------------------------\n"
				 + "Titular: %s\n"
			     + "Tipo de Cuenta: %s\n"
			     + "Fecha de apertura: %s\n"
			     + "Número de cuenta: %d\n", this._titular.toString(),this._nombreTipoCuenta,
			     this._fechaDeApertura.toString(), this._numeroCuenta);
		return _infoCuentaBancaria;
	}
	
	public abstract boolean depositar(double cantidad);
	public abstract boolean retirar(double cantidadRetirar);
	public abstract double consultarSaldo();
	
}
