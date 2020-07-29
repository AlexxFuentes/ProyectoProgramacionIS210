package clases;

public class TransferenciasTerceros extends Transferencias{
	//ATRIBUTOS
	private String _codigoTransferencia; //TT_xxxxxxx
	private Beneficiario _beneficiario;
	public TransferenciasTerceros() {
		super();
	}
	/*
	public TransferenciasTerceros(String _codigoTransferencia, Beneficiario _beneficiario) {
		super();
		this._codigoTransferencia = _codigoTransferencia;
		this._beneficiario = _beneficiario;
	}
	*/
	public TransferenciasTerceros(String _codigoTransferencia, String _tipoMoneda, String _cuentaDebitar, String _cuentaAcreditar,
			double _montoTransferir, String _concepto, String _enviarConfirmacion, Beneficiario _beneficiario) {
		super(_tipoMoneda, _cuentaDebitar, _cuentaAcreditar, _montoTransferir, _concepto, _enviarConfirmacion);
		this._codigoTransferencia = _codigoTransferencia;
		this._beneficiario = _beneficiario;
	}
	public String get_codigoTransferencia() {
		return _codigoTransferencia;
	}
	public void set_codigoTransferencia(String _codigoTransferencia) {
		this._codigoTransferencia = _codigoTransferencia;
	}
	public Beneficiario get_beneficiario() {
		return _beneficiario;
	}
	public void set_beneficiario(Beneficiario _beneficiario) {
		this._beneficiario = _beneficiario;
	}
	
	@Override
	public String toString() {
		/*return "TransferenciasTerceros [_codigoTransferencia=" + _codigoTransferencia + ", _beneficiario="
				+ _beneficiario + "]";
		*/
		String _infoTransaccionesTercero = String.format("TRANSACCIONES A TERCEROS:/n--------------------------------------/n"
													   + "Codigo de transacción: %s\n"
													   + super.toString()
													   + "Beneficiario: %s\n",this._codigoTransferencia, this._codigoTransferencia);
		
		return _infoTransaccionesTercero;
	}
}
