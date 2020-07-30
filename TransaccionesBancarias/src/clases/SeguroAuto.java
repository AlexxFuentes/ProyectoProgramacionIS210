package clases;

import java.util.Date;

public class SeguroAuto extends Seguros {
	//ATRIBUTO DE LA CLASE SEGURO AUTO
	protected String _numeroDePlaca;

	//CONSTRUCTOR POR DEFECTO
	public SeguroAuto() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public SeguroAuto(String _numeroDePlaca) {
		super();
		this._numeroDePlaca = _numeroDePlaca;
	}

	//CONSTRUCTOR DE LA SUPERCLASE
	public SeguroAuto(double _montoaPagar, String _CuentaaDebitar, String _concepto, String _enviarConfirmacion,
			Date _fechaPago, String _codigoSeguro, String _numeroSeguro, String _empresa, Date _fecha, String _numeroDePlaca) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago, _codigoSeguro, _numeroSeguro, _empresa,
				_fecha);
		this._numeroDePlaca=_numeroDePlaca;
	}

	//GETTERS Y SETTERS
	public String get_numeroDePlaca() {
		return _numeroDePlaca;
	}

	public void set_numeroDePlaca(String _numeroDePlaca) {
		this._numeroDePlaca = _numeroDePlaca;
	}

	@Override
	public String toString() {
		String infoSA = String.format("Número de Placa: %s \n",
				this._numeroDePlaca);
		return super.toString()+infoSA;
	}
	
}
