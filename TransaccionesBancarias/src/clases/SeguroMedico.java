package clases;

import java.util.Date;

public class SeguroMedico extends Seguros{
	//ATRIBUTOS DE SEGURO MEDICO
     protected double _salarioBase;
     protected Beneficiario _beneficiario;
     
     //CONSTRUCTOR POR DEFECTO
	public SeguroMedico() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public SeguroMedico(double _salarioBase, Beneficiario _beneficiario) {
		super();
		this._salarioBase = _salarioBase;
		this._beneficiario = _beneficiario;
	}

	//CONSTRUCTOR SUPERCLASE
	public SeguroMedico(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago, String _codigoSeguro, String _numeroSeguro, String _empresa, Date _fecha, double _salarioBase, Beneficiario _beneficiario) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago, _codigoSeguro, _numeroSeguro, _empresa,
				_fecha);
		this._beneficiario=_beneficiario;
		this._salarioBase=_salarioBase;
	}

	//GETTERS Y SETTERS
	public double get_salarioBase() {
		return _salarioBase;
	}

	public void set_salarioBase(double _salarioBase) {
		this._salarioBase = _salarioBase;
	}

	public Beneficiario get_beneficiario() {
		return _beneficiario;
	}

	public void set_beneficiario(Beneficiario _beneficiario) {
		this._beneficiario = _beneficiario;
	}

	//SOBREESCRITURA DEL TOSTRING
	@Override
	public String toString() {
		String infoSM=String.format("Salario Base: %f. \n"
				+ "Beneficiario %s \n", 
				this._salarioBase, this._beneficiario);
		return super.toString()+infoSM;
	}
     
}
