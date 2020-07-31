package clases;

public class TransferenciasACH extends Transferencias{
	
	//ATRIBUTOS
	private String _codigoTransferencias;//TACH_xxxxx
	private String _bancoDestino;
	public TransferenciasACH() {
		super();
	}
	/*
	public TransferenciasACH(String _codigoTransferencias, String _bancoDestino) {
		super();
		this._codigoTransferencias = _codigoTransferencias;
		this._bancoDestino = _bancoDestino;
	}
	*/
	
	
	public String get_codigoTransferencias() {
		return _codigoTransferencias;
	}
	public TransferenciasACH(String _codigoTransferencias, String _tipoMoneda, int _cuentaDebitar, int _cuentaAcreditar, 
			double _montoTransferir, String _concepto, String _enviarConfirmacion,  String _bancoDestino) {
		super(_tipoMoneda, _cuentaDebitar, _cuentaAcreditar, _montoTransferir, _concepto, _enviarConfirmacion);
		this._codigoTransferencias = _codigoTransferencias;
		this._bancoDestino = _bancoDestino;
	}


	public void set_codigoTransferencias(String _codigoTransferencias) {
		this._codigoTransferencias = _codigoTransferencias;
	}
	public String get_bancoDestino() {
		return _bancoDestino;
	}
	public void set_bancoDestino(String _bancoDestino) {
		this._bancoDestino = _bancoDestino;
	}
	
	@Override
	public String toString() {
		/*return "TransferenciasACH [_codigoTransferencias=" + _codigoTransferencias + ", _bancoDestino=" + _bancoDestino
				+ "]";*/
		String _infoTrasferenciasACH = String.format("TRANSFERENCIAS ACH:\n--------------------------------------\n"
												   + "Codigo de transferencia: %s\n"
												   + "Banco destino: %s\n"
												   + super.toString(), this._codigoTransferencias, this._bancoDestino);
		return _infoTrasferenciasACH;
		
	}
}
