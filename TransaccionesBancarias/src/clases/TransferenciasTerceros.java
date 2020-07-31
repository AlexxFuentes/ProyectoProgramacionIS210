package clases;

public class TransferenciasTerceros extends Transferencias{
	//ATRIBUTOS
	private String _codigoTransferencia; //TT_xxxxxxx
	public TransferenciasTerceros() {
		super();
	}
	/*
	public TransferenciasTerceros(String _codigoTransferencia) {
		super();
		this._codigoTransferencia = _codigoTransferencia;
	}
	*/
	public TransferenciasTerceros(String _codigoTransferencia, String _tipoMoneda, int _cuentaDebitar, int _cuentaAcreditar, double _montoTransferir,
			String _concepto, String _enviarConfirmacion) {
		super(_tipoMoneda, _cuentaDebitar, _cuentaAcreditar, _montoTransferir, _concepto, _enviarConfirmacion);
		this._codigoTransferencia = _codigoTransferencia;
	}
	
	public String get_codigoTransferencia() {
		return _codigoTransferencia;
	}
	public void set_codigoTransferencia(String _codigoTransferencia) {
		this._codigoTransferencia = _codigoTransferencia;
	}
	
	@Override
	public String toString() {
		/*return "TransferenciasTerceros [_codigoTransferencia=" + _codigoTransferencia + ", _beneficiario="
				+ _beneficiario + "]";
		*/
		String _infoTransaccionesTercero = String.format("TRANSACCIONES A TERCEROS:\n--------------------------------------\n"
													   + "Codigo de transferencia: %s\n"
													   + super.toString() ,this._codigoTransferencia);
		
		return _infoTransaccionesTercero;
	}
}
