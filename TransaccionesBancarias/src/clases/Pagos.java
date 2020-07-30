package clases;

import java.util.Date;

/*
 * autor: Gleny Nihimaya
 * Fecha: 13/07/20
 * 
 * clase: PagoServiciosPublicos
 * Descripcion: Permite que el usuario elija el
 *              servicio pubico que pagara;
 * 
 * */
public abstract class Pagos {
	//ATRIBUTOS DE LA CLASE PAGOS
	private double _montoaPagar;
	private String _CuentaaDebitar;
	private String _concepto;
	private String _enviarConfirmacion;
	private Date _fechaPago;
	
	//CONSTRUCTOR CON TODOS LOS ATRIBUTOS
	public Pagos(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago) {
		super();
		this._montoaPagar = _montoaPagar;
		this._CuentaaDebitar = _CuentaaDebitar;
		this._concepto = _concepto;
		this._enviarConfirmacion = _enviarConfirmacion;
		this._fechaPago = _fechaPago;
	}

	//CONSTRUCTOR POR DEFECTO
	public Pagos() {
		super();
	}

	//GETTERS Y SETTERS
	public double get_montoaPagar() {
		return _montoaPagar;
	}

	public void set_montoaPagar(double _montoaPagar) {
		this._montoaPagar = _montoaPagar;
	}

	public String get_CuentaaDebitar() {
		return _CuentaaDebitar;
	}

	public void set_CuentaaDebitar(String _CuentaaDebitar) {
		this._CuentaaDebitar = _CuentaaDebitar;
	}

	public String get_concepto() {
		return _concepto;
	}

	public void set_concepto(String _concepto) {
		this._concepto = _concepto;
	}

	public String get_enviarConfirmacion() {
		return _enviarConfirmacion;
	}

	public void set_enviarConfirmacion(String _enviarConfirmacion) {
		this._enviarConfirmacion = _enviarConfirmacion;
	}

	public Date get_fechaPago() {
		return _fechaPago;
	}

	public void set_fechaPago(Date _fechaPago) {
		this._fechaPago = _fechaPago;
	}

	//SOBREESCRITURA DEL TOSTRING
	@Override
	public String toString() {
		return String.format("Monto a Pagar: %f. \nCuenta a Debitar: %s. \nConcepto: %s. \nEnviar Confirmación a: %s. \nFecha de Pago: %s.",
				this._montoaPagar,
				this._CuentaaDebitar,
				this._concepto,
				this._enviarConfirmacion,
				this._fechaPago);
	}
	
	
	
}
