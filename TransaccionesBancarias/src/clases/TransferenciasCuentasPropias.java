package clases;

/*
 * autor: Gleny Nihimaya
 * Fecha: 13/07/20
 * 
 * clase: TransferenciasCuentasPropias
 * Descripcion: Los requisitos que se necesitan
 *            para realizar una transferencia entre cuentas.
 * */

public class TransferenciasCuentasPropias extends Transferencias {
	private String _codigoTransferencia;//TECP_xxxxxx

	public TransferenciasCuentasPropias() {
		super();
	}
	/*
	public TransferenciasEntreCuentasPropias(String _codigoTransferencia) {
		super();
		this._codigoTransferencia = _codigoTransferencia;
	}
	*/
	public TransferenciasCuentasPropias(String _codigoTransferencia, String _tipoMoneda, int _cuentaDebitar, int _cuentaAcreditar,
			double _montoTransferir, String _concepto, String _enviarConfirmacion) {
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
		//return "TransferenciasEntreCuentasPropias [_codigoTransferencia=" + _codigoTransferencia + "]";
		String _infoTransCuentasPropias = String.format("TRANSFERENCIAS ENTRE CUENTAS PROPIAS:/n--------------------------------------/n"
													  + "Codigo de transferencias: %s\n"
													  + super.toString(), this._codigoTransferencia);
		return _infoTransCuentasPropias;
	}
}
