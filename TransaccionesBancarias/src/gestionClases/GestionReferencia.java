package gestionClases;

import java.util.LinkedList;

import clases.Referencia;

/**
 * CLASE GESTI�N DE REFERENCIA: ADMISTRA LOS DATOS PERSONALES DEL USUARIO
 * @author Alex Fuentes
 * 
 * FECHA: 17/07/2020
 */

public class GestionReferencia {
	
	//ATRIBUTOS (COLECCI�N)
	LinkedList<Referencia> _listaReferencia = new LinkedList<>();
	
	/**
	 * M�TODO QUE OBTIENE ELEMENTO DE LA COLEECI�N REFERENCIA
	 * @return listaReferencia
	 */
	public LinkedList<Referencia> getReferencia(){
		return _listaReferencia;
	}
	
	public int buscarReferenciaPosicion(String RTN) {
		int posicion = -1;
		for(int i = 0; i < _listaReferencia.size();) {
			if( _listaReferencia.get(i).get_rtn().equals(RTN) ) {
				posicion = i;
			}
		}
		return posicion;
	}
	/**
	 * M�TODO BUSCAR REFERENCIA POR POCISI�N EN LA COLECCI�N
	 * @param RTN
	 * @return -1 -  SI NO ENCUENTRA LA REFERENCIA, CASO CONTRARIO return i - POSICI�N EN LA COLECCI�N
	 */
	public Referencia buscarReferencia(String RTN) {
		Referencia ReferenciaBuscada = null;
		for(int i= 0; i < _listaReferencia.size(); i++) {
			if(_listaReferencia.get(i).get_rtn().equals(RTN)) {
				ReferenciaBuscada = _listaReferencia.get(i);
				break;
			}
		}
		return ReferenciaBuscada;
	}
	
	/**
	 * M�TODO PARA AGREGAR REFERENCIA DEL USUARIO
	 * @param referencia
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false.
	 */
	public boolean agregarReferencia(Referencia referencia) {
		if(buscarReferenciaPosicion(referencia.get_rtn()) == -1) {
			_listaReferencia.add(referencia);
			return true;
		}else {
			return false;
		}
	}
	/**
	 * M�TODO PARA ELIMINAR REFERENCIA POR POSICI�N
	 * @param posicion
	 * @return false - SI NO ENCUENTRA LA REFERENCIA, CASO CONTRARIO return true - SI SE ELIMINO CORRECTAMENTE
	 */
	public boolean eliminarReferencia(int posicion) {
		if(posicion < 0 || posicion > _listaReferencia.size()) {
			return false;
		}else {
			_listaReferencia.remove(posicion);
			return true;
		}
	}

	/**
	 * M�TODO PARA MODIFICAR REFERENCIA
	 * @param referenciaModificado
	 * @param posicion
	 * @return true - SI SE MODIFICO CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean modificarReferencia(Referencia referenciaModificado, int posicion) {
		
		if(posicion < 0 || posicion > _listaReferencia.size()) {
			return false;
		}else {
			int posicionrefencia = buscarReferenciaPosicion(referenciaModificado.get_rtn());
	
			if(posicionrefencia != -1) {
				_listaReferencia.set(posicion, referenciaModificado);
				return true;
			}else {
				return false;
			}
		}
	} 
	
	/**
	 * M�TODO PARA OBTENER INDICE/POSICI�N DE LA COLECI�N
	 * @param posicion
	 * @return POSICI�N/INDICE DE LA COLECCI�N
	 */
	public Referencia getRTN(int posicion) {
		return _listaReferencia.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaReferencia.size();i++) {
			System.out.println(_listaReferencia.get(i));
		}
	}
	
	public String getCodigoReferencia() {
		String _numReferencia = "REF_" + _listaReferencia.size()+1;
		
		return _numReferencia;
	}
}
