package clases;

import java.util.Date;

public class CuentaCheques extends CuentaBancaria {
	
	//ATRIBUTOS
	private double _saldo;
	private double _interesremunerado;
		
	//CONSTRUCTOR POR DEFECTO
	public CuentaCheques() {
		super();
	}
	/*
	public CuentaCheques(double _saldo, double _interesremunerado) {
		super();
		this._saldo = _saldo;
		this._interesremunerado = _interesremunerado;
	}
	*/

	
	
	public double get_saldo() {
		return _saldo;
	}

	public CuentaCheques(Usuario _titular, Date _fechaDeApertura, String _nombreTipoCuenta,
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
		//return "CuentaCheques [_saldo=" + _saldo + ", _interesremunerado=" + _interesremunerado + "]";
		String _infoCuentaCheques = String.format("Saldo: %f\n"
                + "Intereses Remunerados: %f\n", this._saldo, this._interesremunerado);
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
