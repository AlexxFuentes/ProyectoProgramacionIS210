package clases;

import java.util.Date;

/**
 * CLASE DE CUENTA DE AHORRO: PARA APERTURAR NUEVA CUENTA DE AHORRO
 * @author Alex Fuentes
 *
 *FECHA: 12/07/20
 */

public class CuentaAhorro extends CuentaBancaria{
	
	//ATRIBUTOS
	protected double _saldo;
	protected double _interesremunerado;
	
	//CONSTRUCTOR POR DEFECTO
	public CuentaAhorro() {
		super();
	}
	/*
	public CuentaAhorro(double _saldo, double _interesremunerado) {
		super();
		this._saldo = _saldo;
		this._interesremunerado = _interesremunerado;
	}
	*/
	
	
	public double get_saldo() {
		return _saldo;
	}
	public CuentaAhorro(Usuario _titular, Date _fechaDeApertura, String _nombreTipoCuenta,
			int _numeroCuenta, double _saldo, double _interesremunerado) {
		super(_titular, _fechaDeApertura, _nombreTipoCuenta, _numeroCuenta);
		this._saldo = _saldo;
		this._interesremunerado = _interesremunerado;
	}


	public void set_saldo(double _saldo) {
		this._saldo = _saldo;
	}
	public double get_interesremunerado() {
		return _interesremunerado;
	}
	public void set_interesremunerado(double _interesremunerado) {
		this._interesremunerado = _interesremunerado;
	}
	@Override
	public String toString() {
		//return "CuentaAhorro [_saldo=" + _saldo + ", _interesremunerado=" + _interesremunerado + "]";
		String _infoCuentaAhorro = String.format("Saldo: %f\n"
                + "Intereses remunerados: %f\n", this._saldo, this._interesremunerado);
		return super.toString() + _infoCuentaAhorro;
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
