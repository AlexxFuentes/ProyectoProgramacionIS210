package clases;

import java.util.Date;

/*
 * autor: Gleny Nihimaya
 * Fecha: 13/07/20
 * 
 * clase: Seguros
 * Descripcion: Da a conocer los tipos
 *              de seguros disponibles.
 * 
 * */

public abstract class Seguros extends Pagos{
	//ATRIBUTOS DE LA CLASE SEGUROS
	 private String _codigoSeguro;
	 private String _numeroSeguro;
	 private String _empresa;
	 private Date _fecha;
	 
	 //CONSTRUCTOR POR DEFECTO
	public Seguros() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public Seguros(String _codigoSeguro, String _numeroSeguro, String _empresa, Date _fecha) {
		super();
		this._codigoSeguro = _codigoSeguro;
		this._numeroSeguro = _numeroSeguro;
		this._empresa = _empresa;
		this._fecha = _fecha;
	}

	//CONSTRUCTOR DE LA SUPERCLASE
	public Seguros(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago, String _codigoSeguro, String _numeroSeguro, String _empresa, Date _fecha) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago);
		this._codigoSeguro=_codigoSeguro;
		this._empresa=_empresa;
		this._fecha=_fecha;
		this._numeroSeguro=_numeroSeguro;
	}

	//GETTERS Y SETTERS
	public String get_codigoSeguro() {
		return _codigoSeguro;
	}

	public void set_codigoSeguro(String _codigoSeguro) {
		this._codigoSeguro = _codigoSeguro;
	}

	public String get_numeroSeguro() {
		return _numeroSeguro;
	}

	public void set_numeroSeguro(String _numeroSeguro) {
		this._numeroSeguro = _numeroSeguro;
	}

	public String get_empresa() {
		return _empresa;
	}

	public void set_empresa(String _empresa) {
		this._empresa = _empresa;
	}

	public Date get_fecha() {
		return _fecha;
	}

	public void set_fecha(Date _fecha) {
		this._fecha = _fecha;
	}

	//SOBREESCRITURA DEL TOSTRING
	@Override
	public String toString() {
		String infoSeguros = String.format("Código del Seguro: %s \n"
				+ "Número de Seguro: %s. \n"
				+ "Empresa: %s. \n"
				+ "Fecha: %s", 
				this._codigoSeguro, this._numeroSeguro, this._empresa, this._fecha);
		return super.toString()+infoSeguros;
	}
	 
}
