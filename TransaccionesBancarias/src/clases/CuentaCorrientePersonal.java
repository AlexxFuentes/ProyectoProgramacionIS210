package clases;

import java.util.Date;

/**
 * CLASE DE CUENTA CORRIENTE PERSONAL: APERTURA DE CUENTA
 * 
 * @author Alex Fuentes
 *
 *FECHA: 18/07/2020
 */

public class CuentaCorrientePersonal extends CuentaBancaria{
	
	//ATRIBUTOS
	private double _saldo;
	
	public CuentaCorrientePersonal() {
		super();
	}
	/*
	public CuentaCorrientePersonal(double _saldo) {
		super();
		this._saldo = _saldo;
	}
	*/
	
	public CuentaCorrientePersonal(Usuario _titular, Date _fechaDeApertura, String _nombreTipoCuenta,
			String _numeroCuenta, double _saldo) {
		super(_titular, _fechaDeApertura, _nombreTipoCuenta, _numeroCuenta);
		this._saldo = _saldo;
	}

	public double get_saldo() {
		return _saldo;
	}

	public void set_saldo(double _saldo) {
		this._saldo = _saldo;
	}

	@Override
	public String toString() {
		//return "CuentaCorrientePersonal [_saldo=" + _saldo + "]";
		String _infoCuentaCP = String.format("Saldo: %f\n", this._saldo);
		return super.toString() + _infoCuentaCP;
	}
	
	@Override
	public boolean depositar(double cantidad) {
		if(cantidad <= 0) {
			return false;
		}else {
			this._saldo += cantidad;
			return true;
		}
	}
	@Override
	public boolean retirar(double cantidadRetirar) {
		if(cantidadRetirar <= this._saldo) {
			this._saldo -= cantidadRetirar;
			return true;
		}else {
			return false;
		}
	}
	@Override
	public double consultarSaldo() {
		return this._saldo;
	}

	

	
}
