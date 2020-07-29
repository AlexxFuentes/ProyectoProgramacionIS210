package clases;

import java.util.Date;

public class Beneficiario extends Persona{
	private String _codigoBeneficario;
	private double _porcentajeBeneficiario;
	
	public Beneficiario() {
		super();
	}
	/*
	public Beneficiario(String _codigoBeneficario, double _porcentajeBeneficiario) {
		super();
		this._codigoBeneficario = _codigoBeneficario;
		this._porcentajeBeneficiario = _porcentajeBeneficiario;
	}
	*/

	public Beneficiario(String _codigoBeneficario, double _porcentajeBeneficiario, String _nombre, String _apellido, Date _fechaNacimiento,
			String _direccion, String _telefono, String _rtn, String _correoelectronico) {
		super(_nombre, _apellido, _fechaNacimiento, _direccion, _telefono, _rtn, _correoelectronico);
		this._codigoBeneficario = _codigoBeneficario;
		this._porcentajeBeneficiario = _porcentajeBeneficiario;
	}

	public String get_codigoBeneficario() {
		return _codigoBeneficario;
	}

	public void set_codigoBeneficario(String _codigoBeneficario) {
		this._codigoBeneficario = _codigoBeneficario;
	}

	public double get_porcentajeBeneficiario() {
		return _porcentajeBeneficiario;
	}

	public void set_porcentajeBeneficiario(double _porcentajeBeneficiario) {
		this._porcentajeBeneficiario = _porcentajeBeneficiario;
	}

	@Override
	public String toString() {
		/*
		return "Beneficiario [_codigoBeneficario=" + _codigoBeneficario + ", _porcentajeBeneficiario="
				+ _porcentajeBeneficiario + "]";
				*/
		String _infoBeneficiario = String.format("INFORMACIÓN DE BENEFICIARIO: /n--------------------------------------/n"
											   + "Código del beneficiario: %s\n"
											   + "Porcentaje del beneficiario: %f\n", this._codigoBeneficario, this._porcentajeBeneficiario);
		return _infoBeneficiario + super.toString();
	}
}
