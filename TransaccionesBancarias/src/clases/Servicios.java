package clases;

import java.util.Date;

/*
 * autor: Gleny Nihimaya
 * Fecha: 13/07/20
 * 
 * clase: ServiciosPublicos
 * Descripcion: Administra los servicios
 *              los cuales el usuario puede pagar.
 * 
 * */

public class Servicios extends Pagos{
   //ATRIBUTOS DE LA CLASE SERVICIOS
	protected String _codigoServicios;
	protected double _tasaSeguridad;
	protected String _nombreEmpresa;
	protected String _tipoServicio;
	
	//CONSTRUCTOR POR DEFECTO
	public Servicios() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public Servicios(String _codigoServicios, double _tasaSeguridad, String _nombreEmpresa, String _tipoServicio) {
		super();
		this._codigoServicios = _codigoServicios;
		this._tasaSeguridad = _tasaSeguridad;
		this._nombreEmpresa = _nombreEmpresa;
		this._tipoServicio = _tipoServicio;
	}

	//CONSTRUCTOR DE LA SUPERCLASE
	public Servicios(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago, String _codigoServicios, double _tasaSeguridad, String _nombreEmpresa, String _tipoServicio) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago);
		this._codigoServicios = _codigoServicios;
		this._nombreEmpresa = _nombreEmpresa;
		this._tasaSeguridad = _tasaSeguridad;
		this._tipoServicio = _tipoServicio;
	}

	//GETTERS Y SETTERS
	public String get_codigoServicios() {
		return _codigoServicios;
	}

	public void set_codigoServicios(String _codigoServicios) {
		this._codigoServicios = _codigoServicios;
	}

	public double get_tasaSeguridad() {
		return _tasaSeguridad;
	}

	public void set_tasaSeguridad(double _tasaSeguridad) {
		this._tasaSeguridad = _tasaSeguridad;
	}

	public String get_nombreEmpresa() {
		return _nombreEmpresa;
	}

	public void set_nombreEmpresa(String _nombreEmpresa) {
		this._nombreEmpresa = _nombreEmpresa;
	}

	public String get_tipoServicio() {
		return _tipoServicio;
	}

	public void set_tipoServicio(String _tipoServicio) {
		this._tipoServicio = _tipoServicio;
	}

	//SOBREESCRITURA DEL TOSTRING
	@Override
	public String toString() {
		String infoServicio = String.format("Código del Servicio: %s. \n"
				+ "Nombre de la Empresa: %s \n"
				+ "Tasa de Seguridad: %f \n"
				+ "Tipo de Servicio", 
				this._codigoServicios, this._nombreEmpresa, this._tasaSeguridad, this._tipoServicio);
		return super.toString()+infoServicio;
	}
	
}
