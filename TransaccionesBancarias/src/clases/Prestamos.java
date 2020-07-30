package clases;

import java.util.Date;

//Gleny

public class Prestamos extends Pagos{
	//ATRIBUTOS DE PRESTAMOS
	protected int _codigoPrestamo;
	protected String _tipoPrestamo;
	
	//CONSTRRUCTOR POR DEFECTO
	public Prestamos() {
		super();
	}

	//CONSTRUCTOR CON SUS ATROBUTOS
	public Prestamos(int _codigoPrestamo, String _tipoPrestamo) {
		super();
		this._codigoPrestamo = _codigoPrestamo;
		this._tipoPrestamo = _tipoPrestamo;
	}

	//CONSTRUCTOR SUPERCLASE
	public Prestamos(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago, int _codigoPrestamo, String _tipoPrestamo) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago);
		this._codigoPrestamo=_codigoPrestamo;
		this._tipoPrestamo=_tipoPrestamo;
	}

	//GETTERS Y SETTERS
	public int get_codigoPrestamo() {
		return _codigoPrestamo;
	}

	public void set_codigoPrestamo(int _codigoPrestamo) {
		this._codigoPrestamo = _codigoPrestamo;
	}

	public String get_tipoPrestamo() {
		return _tipoPrestamo;
	}

	public void set_tipoPrestamo(String _tipoPrestamo) {
		this._tipoPrestamo = _tipoPrestamo;
	}

	//SOBREESCRITURA DEL TOSTRING
	@Override
	public String toString() {
		String infoPrestamos=String.format("Codigo Prestamo: %d. \n"
				+ "Tipo de Prestamo: %s. \n",
				this._codigoPrestamo, this._tipoPrestamo);
		return super.toString()+infoPrestamos;
	}
	
}
