package clases;

import java.util.Date;

public abstract class Persona {
	private String _nombre;
	private String _apellido;
	private Date _fechaNacimiento;
	private String _direccion;
	private String _telefono;
	private String _rtn;
	private String _correoelectronico;
	
	public Persona() {
		super();
	}

	public Persona(String _nombre, String _apellido, Date _fechaNacimiento, String _direccion, String _telefono,
			String _rtn, String _correoelectronico) {
		super();
		this._nombre = _nombre;
		this._apellido = _apellido;
		this._fechaNacimiento = _fechaNacimiento;
		this._direccion = _direccion;
		this._telefono = _telefono;
		this._rtn = _rtn;
		this._correoelectronico = _correoelectronico;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String get_apellido() {
		return _apellido;
	}

	public void set_apellido(String _apellido) {
		this._apellido = _apellido;
	}

	public Date get_fechaNacimiento() {
		return _fechaNacimiento;
	}

	public void set_fechaNacimiento(Date _fechaNacimiento) {
		this._fechaNacimiento = _fechaNacimiento;
	}

	public String get_direccion() {
		return _direccion;
	}

	public void set_direccion(String _direccion) {
		this._direccion = _direccion;
	}

	public String get_telefono() {
		return _telefono;
	}

	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}

	public String get_rtn() {
		return _rtn;
	}

	public void set_rtn(String _rtn) {
		this._rtn = _rtn;
	}

	public String get_correoelectronico() {
		return _correoelectronico;
	}

	public void set_correoelectronico(String _correoelectronico) {
		this._correoelectronico = _correoelectronico;
	}

	@Override
	public String toString() {
		/*return "Persona [_nombre=" + _nombre + ", _apellido=" + _apellido + ", _fechaNacimiento=" + _fechaNacimiento
				+ ", _direccion=" + _direccion + ", _telefono=" + _telefono + ", _rtn=" + _rtn + ", _correoelectronico="
				+ _correoelectronico + "]";
				*/
		String _infoPersona = String.format("Nombre: %s \n"
										  + "Apellido: %s \n"
										  + "Fecha nacimiento: %s \n"
										  + "Dirección: %s \n"
										  + "Telefono: %s \n"
										  + "RTN: %s \n"
										  + "Correo Electronico: %s \n", this._nombre, this._apellido, this._fechaNacimiento.toString(),
										    this._direccion, this._telefono, this._rtn, this._correoelectronico);
		return _infoPersona;
	}
	
}
