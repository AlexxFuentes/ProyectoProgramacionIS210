package gestionClases;

import java.util.LinkedList;
import clases.Seguros;

/**
 * CLASE: SEGUROS
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionSeguros {
	//COLECCIÓN
      private LinkedList<Seguros> _listaSeguros = new LinkedList<>();
      
    /**
     * METODO PARA BUSCAR SEGURO
     * @param seguro
     * return seguroEncontrado
     */ 
	
	public Seguros buscarSeguro(Seguros seguroBuscado) {
		seguroBuscado = null;
		for(int i=0; i<_listaSeguros.size();i++) {
			if(_listaSeguros.get(i).equals(seguroBuscado)) {
				
				seguroBuscado = _listaSeguros.get(i);
			}
		}
		return seguroBuscado;
	}
	
	/**
     * METODO PARA AGREGAR SEGURO
     * @param seguro
     * return seguroEncontrado
     */ 
	
	public boolean agregarSeguro(Seguros agregarSeguro) {
		if(buscarSeguro(agregarSeguro) == null) {
			_listaSeguros.add(agregarSeguro);
			return true;
		}else {
			return false;
		}
	}
	
	/**
     * METODO PARA MODIFICAR SEGURO
     * @param seguroModificado
     * return TRUE. SI TODO SE REALIZO CORRECTAMENTE, CASO CONTRARIO RETORNARA FALSE.
     */ 
	
	public boolean modificarSeguro(Seguros seguroModificado, int posicion ) {
		if(posicion<0 || posicion>_listaSeguros.size()) {
			return false;
		}else {
			if(buscarSeguro(seguroModificado) != null) {
				_listaSeguros.set(posicion, seguroModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL SEGURO
	 * @param seguroEliminado 
	 * @return true - SI TODO SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean eliminarSeguro(Seguros seguroEliminado) {
		if(buscarSeguro(seguroEliminado) == null) {
			return false;
		}else {
			_listaSeguros.remove(seguroEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaSeguros.size();i++) {
			System.out.println(_listaSeguros.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SEGUROS
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Seguros getPosicion(int posicion) {
		return _listaSeguros.get(posicion);
	}
	
	
}
