package clases;

import java.util.Date;

/**
 * CLASE CUENTA DE NOMINA: APERTURA DE CUENTA NOMINA
 * @author Alex Fuentes
 * 
 *FECHA: 12/07/20
 */

public class CuentaNomina extends CuentaBancaria{
	
	//ATRIBUTOS
	private double _saldo;
	private String _empresaDepositante;
	
	//CONSTRUCTOR POR DEFECTO
	public CuentaNomina() {
		super();
	}
	/*
	public CuentaNomina(double _saldo, String _empresaDepositante) {
		super();
		this._saldo = _saldo;
		this._empresaDepositante = _empresaDepositante;
	}
	*/
	public CuentaNomina(Usuario _titular, Date _fechaDeApertura, String _nombreTipoCuenta,
			String _numeroCuenta, double _saldo, String _empresaDepositante) {
		super(_titular, _fechaDeApertura, _nombreTipoCuenta, _numeroCuenta);
		this._saldo = _saldo;
		this._empresaDepositante = _empresaDepositante;
	}

	public double get_saldo() {
		return _saldo;
	}

	public void set_saldo(double _saldo) {
		this._saldo = _saldo;
	}


	public String get_empresaDepositante() {
		return _empresaDepositante;
	}


	public void set_empresaDepositante(String _empresaDepositante) {
		this._empresaDepositante = _empresaDepositante;
	}
	
	@Override
	public String toString() {
		//return "CuentaNomina [_saldo=" + _saldo + ", _empresaDepositante=" + _empresaDepositante + "]";
		String _infoCuentaCheques = String.format("Empresa depositante: %s\n"
                + "Saldo: %f\n", this._empresaDepositante, this._saldo);
		return super.toString() + _infoCuentaCheques;
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
