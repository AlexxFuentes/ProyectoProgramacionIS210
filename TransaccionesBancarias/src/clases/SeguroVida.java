package clases;

import java.util.Date;

public class SeguroVida extends Seguros{
	/*
	_cantidad asegurada (double)
	_beneficiario (Beneficiario)
	*/
	protected double _cantidadAsegurada;
	protected Beneficiario _beneficario;
	
	//CONSTRUCTOR POR DEFECTO
	public SeguroVida() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public SeguroVida(double _cantidadAsegurada, Beneficiario _beneficario) {
		super();
		this._cantidadAsegurada = _cantidadAsegurada;
		this._beneficario = _beneficario;
	}

	//CONSTRUCTOR DE LA SUPERCLASE
	public SeguroVida(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago, String _codigoSeguro, String _numeroSeguro, String _empresa, Date _fecha, double _cantidadAsegurada, Beneficiario _beneficario) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago, _codigoSeguro, _numeroSeguro, _empresa,
				_fecha);
		this._beneficario=_beneficario;
		this._cantidadAsegurada=_cantidadAsegurada;
	}

	//GETTERS Y SETTERS
	public double get_cantidadAsegurada() {
		return _cantidadAsegurada;
	}

	public void set_cantidadAsegurada(double _cantidadAsegurada) {
		this._cantidadAsegurada = _cantidadAsegurada;
	}

	public Beneficiario get_beneficario() {
		return _beneficario;
	}

	public void set_beneficario(Beneficiario _beneficario) {
		this._beneficario = _beneficario;
	}

	//SOBREESCRITURA DEL TOSTRING
	@Override
	public String toString() {
		String infoSV=String.format("Beneficiario: %s. \n"
				+ "Cantidad Asegurada: %f \n",
				this._beneficario, this._cantidadAsegurada);
		return super.toString()+infoSV;
	}
	
}
