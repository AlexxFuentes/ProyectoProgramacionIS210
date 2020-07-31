package clases;

/*
 * autor: Gleny Nihimaya
 * Fecha: 13/07/20
 * 
 * clase: Transferencias
 * Descripcion: Tipo de transferencias que
 *             puedan realizarse.
 * */

public abstract class Transferencias {
	
	//ATRIBUTOS
	private String _tipoMoneda;
	private int _cuentaDebitar;
	private int _cuentaAcreditar;
	private double _montoTransferir;
	private String _concepto;
	private String _enviarConfirmacion;//correo

	//CONSTRUCTOR POR DEFECTOS
	public Transferencias() {
		super();
	}

	public Transferencias(String _tipoMoneda, int _cuentaDebitar, int _cuentaAcreditar, double _montoTransferir,
			String _concepto, String _enviarConfirmacion) {
		super();
		this._tipoMoneda = _tipoMoneda;
		this._cuentaDebitar = _cuentaDebitar;
		this._cuentaAcreditar = _cuentaAcreditar;
		this._montoTransferir = _montoTransferir;
		this._concepto = _concepto;
		this._enviarConfirmacion = _enviarConfirmacion;
	}

	public String get_tipoMoneda() {
		return _tipoMoneda;
	}

	public void set_tipoMoneda(String _tipoMoneda) {
		this._tipoMoneda = _tipoMoneda;
	}

	public int get_cuentaDebitar() {
		return _cuentaDebitar;
	}

	public void set_cuentaDebitar(int _cuentaDebitar) {
		this._cuentaDebitar = _cuentaDebitar;
	}

	public int get_cuentaAcreditar() {
		return _cuentaAcreditar;
	}

	public void set_cuentaAcreditar(int _cuentaAcreditar) {
		this._cuentaAcreditar = _cuentaAcreditar;
	}

	public double get_montoTransferir() {
		return _montoTransferir;
	}

	public void set_montoTransferir(double _montoTransferir) {
		this._montoTransferir = _montoTransferir;
	}

	public String get_concepto() {
		return _concepto;
	}

	public void set_concepto(String _concepto) {
		this._concepto = _concepto;
	}

	public String get_enviarConfirmacion() {
		return _enviarConfirmacion;
	}

	public void set_enviarConfirmacion(String _enviarConfirmacion) {
		this._enviarConfirmacion = _enviarConfirmacion;
	}

	@Override
	public String toString() {
		/*return "Transferencias [_beneficiario=" + _beneficiario + ", _tipoMoneda=" + _tipoMoneda + ", _cuentaDebitar="
				+ _cuentaDebitar + ", _cuentaAcreditar=" + _cuentaAcreditar + ", _montoTransferir=" + _montoTransferir
				+ ", _concepto=" + _concepto + ", _enviarConfirmacion=" + _enviarConfirmacion + "]";
		*/
		String _infoTransferencia = String.format("Tipo de moneda: %s\n"
												+ "Cuenta a debitar: %s\n"
												+ "Cuenta a acreditar: %s\n"
												+ "Monto  a transferir: %f\n"
												+ "Concepto: %s\n"
												+ "Enviar confirmación a: %s\n", this._tipoMoneda, this._cuentaDebitar, 
												this._cuentaAcreditar, this._montoTransferir, this._concepto, this._enviarConfirmacion);
		return _infoTransferencia;
	}	
}
