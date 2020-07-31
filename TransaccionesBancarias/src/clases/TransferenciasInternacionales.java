package clases;

/*
 * autor: Gleny Nihimaya
 * Fecha: 13/07/20
 * 
 * clase: TransferenciasInterbancarias
 * Descripcion: Selecciona la cantidad de dinero
 *            y las opciones de bancos a transferir.
 * */

public class TransferenciasInternacionales extends Transferencias{
	//ATRIBUTOS
	private String _codigotransferencias;
	private String _bancoDestino;
	
	public TransferenciasInternacionales() {
		super();
	}
	/*
	public TransferenciasInternacionales(String _codigotransferencias, String _bancoDestino) {
		super();
		this._codigotransferencias = _codigotransferencias;
		this._bancoDestino = _bancoDestino;
	}
	*/
	public TransferenciasInternacionales(String _codigotransferencias, String _tipoMoneda, int _cuentaDebitar, int _cuentaAcreditar,
			double _montoTransferir, String _concepto, String _enviarConfirmacion, String _bancoDestino) {
		super(_tipoMoneda, _cuentaDebitar, _cuentaAcreditar, _montoTransferir, _concepto, _enviarConfirmacion);
		this._codigotransferencias = _codigotransferencias;
		this._bancoDestino = _bancoDestino;
	}

	
	
	public String get_codigotransferencias() {
		return _codigotransferencias;
	}
	
	public void set_codigotransferencias(String _codigotransferencias) {
		this._codigotransferencias = _codigotransferencias;
	}
	public String get_bancoDestino() {
		return _bancoDestino;
	}
	public void set_bancoDestino(String _bancoDestino) {
		this._bancoDestino = _bancoDestino;
	}
	
	@Override
	public String toString() {
		/*return "TransferenciasInternacionales [_codigotransferencias=" + _codigotransferencias + ", _bancoDestino="
				+ _bancoDestino + "]";*/
		String _infoTransaccionInternacional = String.format("TRANSACCIONES INTERNACIONALES:\n--------------------------------------\n"
														   + "Codigo de transferencias: %s\n"
														   + "Banco destino: %s\n"
														   + super.toString(), this._codigotransferencias, this._bancoDestino);
		
		return _infoTransaccionInternacional; 
	}
}
