package clases;

import java.util.Date;

import utileria.AdminFechas;

/**
 * CLASE TIPO CUENTA: ADMINISTRA LOS TIPOS DE CUENTA
 *                    CREADAS POR EL USUARIO
 * @author Alex Fuentes
 * 
 *FECHA: 18/07/2020
 */

public abstract class CuentaBancaria {
	
	//ATRIBUTOS
	//private Usuario _titular;
	private Date _fechaDeApertura = AdminFechas.getFechaActual();
	private String _nombreTipoCuenta;
	private String _numeroCuenta;
	
	//CONSTRUCTOR POR DEFECTO
	public CuentaBancaria() {
		super();
	}
	public CuentaBancaria(Date _fechaDeApertura, String _nombreTipoCuenta, String _numeroCuenta) {
		super();
		this._fechaDeApertura = _fechaDeApertura;
		this._nombreTipoCuenta = _nombreTipoCuenta;
		this._numeroCuenta = _numeroCuenta;
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
	public String get_numeroCuenta() {
		return _numeroCuenta;
	}
	public void set_numeroCuenta(String _numeroCuenta) {
		this._numeroCuenta = _numeroCuenta;
	}
	
	@Override
	public String toString() {
		/*
		return "CuentaBancaria [_fechaDeApertura=" + _fechaDeApertura + ", _nombreTipoCuenta=" + _nombreTipoCuenta
				+ ", _numeroCuenta=" + _numeroCuenta + "]";
				*/
		String _infoCuentaBancaria = String.format("\nCUENTA BANCARIA:\n--------------------------------------\n"
											     + "Tipo de Cuenta: %s\n"
											     + "Fecha de apertura: %s\n"
											     + "Número de cuenta: %s\n", this._nombreTipoCuenta, this._fechaDeApertura.toString(), 
											     this._numeroCuenta);
		return _infoCuentaBancaria;
	}
	
	//METODOS ABSTRACTOS
	public abstract boolean depositar(double cantidad);
	public abstract boolean retirar(double cantidadRetirar);
	public abstract double consultarSaldo();
	
}
