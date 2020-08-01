package gestionClases;

import java.util.LinkedList;

import clases.TarjetaCredito;

/**
 * CLASE: TARJETASCREDITOPROPIAS
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionTarjetasCretitoPropias {
	
	//ATRIBUTO GESTION TARJETAS CREDITPO PROPIAS
	private LinkedList<TarjetaCredito> _listaTCP = new LinkedList<>();
	
	
	/**
     * METODO PARA BUSCAR TCP
     * @param tcp
     * return tcp
     */
	
	public TarjetaCredito buscarTarjetaTCP(TarjetaCredito tcp) {
		TarjetaCredito tcpBuscada = null;
		
		for(int i = 0; i < _listaTCP.size(); i++) {
			if( _listaTCP.get(i).equals(tcp)) {
				tcpBuscada = _listaTCP.get(i);
			}
		}
		return tcpBuscada;
	}
	
	/**
	 * MÉTODO QUE AGREGAR TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCP
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean agregarTarjetaTCP(TarjetaCredito tarjetaTCP) {
		
		if(buscarTarjetaTCP(tarjetaTCP) == null) {//Si la tarjeta no esta agregada
			
			_listaTCP.add(tarjetaTCP);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA LA TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCPModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean modificarTarjetaTCP(TarjetaCredito tarjetaTCPModificar, int posicion) {
		if(posicion<0 || posicion>_listaTCP.size()) {
			return false;
		}else {
	
			if(buscarTarjetaTCP(tarjetaTCPModificar) != null) {
				_listaTCP.set(posicion, tarjetaTCPModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR LA TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCPEliminar
	 * @return true - SI TODOS SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean eliminarTarjetaTCP(TarjetaCredito tarjetaTCPEliminar) {
		
		if(buscarTarjetaTCP(tarjetaTCPEliminar) == null) {
			return false;
		}else {
			_listaTCP.remove(buscarTarjetaTCP(tarjetaTCPEliminar));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN TARJETA CREDITO PROPIAS
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public TarjetaCredito getPosicion(int posicion) {
		return _listaTCP.get(posicion);
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaTCP.size();i++) {
			System.out.println(_listaTCP.get(i));
		}
	}
}
