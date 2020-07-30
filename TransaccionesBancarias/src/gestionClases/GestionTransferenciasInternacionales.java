package gestionClases;

import java.util.LinkedList;

import clases.TransferenciasInternacionales;

//Alex

public class GestionTransferenciasInternacionales {

	private LinkedList<TransferenciasInternacionales> _listaTransferenciasInternacionales = new LinkedList<>();
	
	public GestionTransferenciasInternacionales() {
		super();
	}

	public GestionTransferenciasInternacionales(
			LinkedList<TransferenciasInternacionales> _listaTransferenciasInternacionales) {
		super();
		this._listaTransferenciasInternacionales = _listaTransferenciasInternacionales;
	}

	public TransferenciasInternacionales buscarTI(TransferenciasInternacionales TInternacionales) {
		TransferenciasInternacionales tranfInternacionalBuscada = null;
		for(int i = 0; i < _listaTransferenciasInternacionales.size(); i++) {
			if(_listaTransferenciasInternacionales.get(i).equals(TInternacionales)) {
				tranfInternacionalBuscada = _listaTransferenciasInternacionales.get(i);
				break;
			}
		}
		return tranfInternacionalBuscada;
	}
	
	public boolean agregarTI(TransferenciasInternacionales Tinternacional) {
		if(buscarTI(Tinternacional) == null) {
			_listaTransferenciasInternacionales.add(Tinternacional);
			return true;
		}else {
			return true;
		}
	}

	
	

	public void imprimirtodo() {
		for(int i = 0; i < _listaTransferenciasInternacionales.size(); i++) {
			System.out.println(_listaTransferenciasInternacionales.get(i));
		}
	}
	
	public String getCodigoTI() {
		String _codigoTI =  "TECP_" + _listaTransferenciasInternacionales.size() + 1;
		
		return _codigoTI;
	}
}
