package clases;

import java.util.Date;

//Gleny

public class TarjetaCreditoPropias extends Pagos{
    //ATRIBUTOS DE LA CLASE TARJETA CREDITO PROPIAS
	protected String _codigoTCP;
	protected String _tarjetaPagar;
	protected String _tipoMoneda;
	
	//CONSTRUCTOR POR SUS ATRIBUTOS
	public TarjetaCreditoPropias(String _codigoTCP, String _tarjetaPagar, String _tipoMoneda) {
		super();
		this._codigoTCP = _codigoTCP;
		this._tarjetaPagar = _tarjetaPagar;
		this._tipoMoneda = _tipoMoneda;
	}

	//CONSTRUCTOR POR DEFECTO
	public TarjetaCreditoPropias() {
		super();
	}

	//CONSTRUCTOR SUPERCLASE
	public TarjetaCreditoPropias(double _montoaPagar, String _CuentaaDebitar, String _concepto,
			String _enviarConfirmacion, Date _fechaPago, String _codigoTCP, String _tarjetaPagar, String _tipoMoneda) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago);
		this._codigoTCP = _codigoTCP;
		this._tarjetaPagar = _tarjetaPagar;
		this._tipoMoneda = _tipoMoneda;
	}

	//SETTERS Y GETTERS
	public String get_codigoTCP() {
		return _codigoTCP;
	}

	public void set_codigoTCP(String _codigoTCP) {
		this._codigoTCP = _codigoTCP;
	}

	public String get_tarjetaPagar() {
		return _tarjetaPagar;
	}

	public void set_tarjetaPagar(String _tarjetaPagar) {
		this._tarjetaPagar = _tarjetaPagar;
	}

	public String get_tipoMoneda() {
		return _tipoMoneda;
	}

	public void set_tipoMoneda(String _tipoMoneda) {
		this._tipoMoneda = _tipoMoneda;
	}

	//SOBREESCRIBIR TOSTRING
	@Override
	public String toString() {
		String infoTCP = String.format("Código TCT: %s. \n"
				+ "Tarjeta a Pagar: %s \n"
				+ "Tipo de Moneda %s. \n", this._codigoTCP, this._tarjetaPagar, this._tipoMoneda);
		return super.toString()+infoTCP;
	}
	
}
