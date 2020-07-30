package gestionClases;

import java.util.LinkedList;

import clases.TransferenciasTerceros;

//Alex

public class GestionTransferenciasTerceros {
	
	private LinkedList<TransferenciasTerceros> _listaTransferenciasTerceros = new LinkedList<>();

	public GestionTransferenciasTerceros() {
		super();
	}

	public GestionTransferenciasTerceros(LinkedList<TransferenciasTerceros> _listaTransferenciasTerceros) {
		super();
		this._listaTransferenciasTerceros = _listaTransferenciasTerceros;
	}
	
	public TransferenciasTerceros buscarTT(TransferenciasTerceros transferencia) {
		TransferenciasTerceros transferenciaBuscada = null;
		for(int j=0; j < _listaTransferenciasTerceros.size(); j++) {
			if(_listaTransferenciasTerceros.get(j).equals(transferencia)) {
				transferenciaBuscada = _listaTransferenciasTerceros.get(j);
			}
		}
		return transferenciaBuscada;
	}

	public boolean agregarTT(TransferenciasTerceros transferncia) {
		if(buscarTT(transferncia) == null){
			_listaTransferenciasTerceros.add(transferncia);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean eliminarTT(TransferenciasTerceros transEliminar) {
		if(buscarTT(transEliminar) == null) {
			return false;
		}else {
			_listaTransferenciasTerceros.remove(transEliminar);
	     	return true;
	    }
	}
	
	public void imprimir() {
		for(int i = 0; i < _listaTransferenciasTerceros.size(); i++) {
			System.out.println(_listaTransferenciasTerceros.get(i));
		}
	}
	
	public String getCodigoTT() {
		String _codigoTT =  "TACH_" + _listaTransferenciasTerceros.size() + 1;
		
		return _codigoTT;
	}
}
