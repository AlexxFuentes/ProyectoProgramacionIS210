package clases;

import java.util.Date;

/**
 * CLASE REFERENCIA: AMINISTRA LOS DATOS DE REFERENCIA QUE 
 * PROPONE EL USUARIO AL MOMENTO DE CREAR UNA CUENTA DE 
 * CUALQUIER TIPO
 * 
 * @author Alex Fuentes
 *
 *Fecha: 12/07/2020
 */
public class Referencia extends Persona{
	
	//ATRIBUTOS
	protected String _codigoReferencia;
	
	//CONSTRUCTOR POR DEFECTO
	public Referencia() {
		super();
	}
	/*
	public Referencia(String _codigoReferencia) {
		super();
		this._codigoReferencia = _codigoReferencia;
	}
	*/
	public Referencia(String _codigoReferencia, String _nombre, String _apellido, Date _fechaNacimiento, String _direccion,
					  String _telefono, String _rtn, String _correoelectronico) {
		super(_nombre, _apellido, _fechaNacimiento, _direccion, _telefono, _rtn, _correoelectronico);
		this._codigoReferencia = _codigoReferencia;
	}
	public String get_codigoReferencia() {
		return _codigoReferencia;
	}
	public void set_codigoReferencia(String _codigoReferencia) {
		this._codigoReferencia = _codigoReferencia;
	}
	
	@Override
	public String toString() {
		/*
		return "Referencia [_codigoReferencia=" + _codigoReferencia + "]";
		*/
		String _infoReferencia = String.format("INFORMACIÓN DE REFERENCIA:\n--------------------------------------\n"
											 + "Código de referencias: %s\n", this._codigoReferencia);
		
		return _infoReferencia + super.toString();
	}
}
