package clases;

import java.util.Date;
import java.util.LinkedList;

/**
 * CLASE USUARIO: ADMINISTRA LOS DATOS DEL USUARIO O
 *                TUROR DE LA CUENTA A CREAR
 * @author Alex Fuentes
 *
 *FECHA: 12/07/2020
 */

public class Usuario extends Persona{
	
	//ATRIBUTOS
	private String _codigoUsuario;
	private Date _fechaRegistro;
	private String _nombreUsuario;
	private String _contrasena;
	private String _referencia;
	private LinkedList<CuentaBancaria> _listaCuentasBancarias = new LinkedList<>();
	
	public Usuario() {
		super();
	}
	/*
	public Usuario(String _codigoUsuario, Date _fechaRegistro, String _nombreUsuario, String _contrasena,
			String _referencia, LinkedList<CuentaBancaria> _listaCuentasBancarias) {
		super();
		this._codigoUsuario = _codigoUsuario;
		this._fechaRegistro = _fechaRegistro;
		this._nombreUsuario = _nombreUsuario;
		this._contrasena = _contrasena;
		this._referencia = _referencia;
		this._listaCuentasBancarias = _listaCuentasBancarias;
	}
	*/
	public Usuario(String _codigoUsuario,Date _fechaRegistro, String _nombre, String _apellido, Date _fechaNacimiento, String _direccion,
			String _telefono, String _rtn, String _correoelectronico, String _nombreUsuario, String _contrasena, LinkedList<CuentaBancaria> _listaCuentasBancarias) {
		super(_nombre, _apellido, _fechaNacimiento, _direccion, _telefono, _rtn, _correoelectronico);
		this._codigoUsuario = _codigoUsuario;
		this._fechaRegistro = _fechaRegistro;
		this._nombreUsuario = _nombreUsuario;
		this._contrasena = _contrasena;
		this._listaCuentasBancarias = _listaCuentasBancarias;
	}
	
	
	
	public String get_codigoUsuario() {
		return _codigoUsuario;
	}
	public void set_codigoUsuario(String _codigoUsuario) {
		this._codigoUsuario = _codigoUsuario;
	}
	public Date get_fechaRegistro() {
		return _fechaRegistro;
	}
	public void set_fechaRegistro(Date _fechaRegistro) {
		this._fechaRegistro = _fechaRegistro;
	}
	public String get_nombreUsuario() {
		return _nombreUsuario;
	}
	public void set_nombreUsuario(String _nombreUsuario) {
		this._nombreUsuario = _nombreUsuario;
	}
	public String get_contrasena() {
		return _contrasena;
	}
	public void set_contrasena(String _contrasena) {
		this._contrasena = _contrasena;
	}
	public String get_referencia() {
		return _referencia;
	}
	public void set_referencia(String _referencia) {
		this._referencia = _referencia;
	}
	public LinkedList<CuentaBancaria> get_listaCuentasBancarias() {
		return _listaCuentasBancarias;
	}
	public void set_listaCuentasBancarias(LinkedList<CuentaBancaria> _listaCuentasBancarias) {
		this._listaCuentasBancarias = _listaCuentasBancarias;
	}
	@Override
	public String toString() {
		/*return "Usuario [_codigoUsuario=" + _codigoUsuario + ", _fechaRegistro=" + _fechaRegistro + ", _nombreUsuario="
				+ _nombreUsuario + ", _confirmarNombreUsuario=" + _confirmarNombreUsuario + ", _contrasena="
				+ _contrasena + ", _confirmarContrasena=" + _confirmarContrasena + ", _listaCuentaBanacarias="
				+ _listaCuentaBanacarias + "]";
				*/
		String _infoUsuario = String.format("INFORMACIÓN DEL TITULAR:\n--------------------------------------\n"
				                          + "Codigo del titular: %s\n"
				                          + "Fecha registro: %s\n"
				                          + super.toString()
				                          + "Nombre de Usuario: %s\n"
				                          + "Contraseña: %s\n"
				                          + "Cuentas bancarias: %s\n", this._codigoUsuario, this._fechaRegistro.toString(),
				                          this._nombreUsuario, this._contrasena,this._listaCuentasBancarias.toString());
		
		return _infoUsuario ;
	}
	
	public boolean AgregarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		_listaCuentasBancarias.add(cuentaBancaria);
			return true;
	}
}
