package clases;

import java.util.Date;

//Gleny

public class TarjetaCreditoTerceros extends Pagos{
    //ATRIBUTOS DE LA CLASE TARJETACREDITOTERCEROS
	private String _codigoTCT;
	private String _tarjetaPagar;
	private String _tipoMoneda;
	
	//CONSTRUCTOR POR DEFECTO
	public TarjetaCreditoTerceros() {
		super();
	}

	//CONSTRUCTOR CON TODOS LOS ATRIBUTOS
	public TarjetaCreditoTerceros(String _codigoTCT, String _tarjetaPagar, String _tipoMoneda) {
		super();
		this._codigoTCT = _codigoTCT;
		this._tarjetaPagar = _tarjetaPagar;
		this._tipoMoneda = _tipoMoneda;
	}

	//CONSTRUCTOR SUPERCLASE
	public TarjetaCreditoTerceros(double _montoaPagar, String _CuentaaDebitar, String _concepto,
			String _enviarConfirmacion, Date _fechaPago, String _codigoTCT, String _tarjetaPagar, String _tipoMoneda) {
		super(_montoaPagar, _CuentaaDebitar, _concepto, _enviarConfirmacion, _fechaPago);
		this._codigoTCT = _codigoTCT;
		this._tarjetaPagar = _tarjetaPagar;
		this._tipoMoneda = _tipoMoneda;
	}

	//GETTERS Y SETTERS
	public String get_codigoTCT() {
		return _codigoTCT;
	}

	public void set_codigoTCT(String _codigoTCT) {
		this._codigoTCT = _codigoTCT;
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
		String infoTCT = String.format("Código TCT: %s. \n"
				+ "Tarjeta a Pagar: %s \n"
				+ "Tipo de Moneda %s. \n", this._codigoTCT, this._tarjetaPagar, this._tipoMoneda);
		return super.toString()+infoTCT;
	}
	


}
