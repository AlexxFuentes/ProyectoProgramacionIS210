package gestionClases;

import java.util.LinkedList;

import clases.SeguroAuto;

/**
 * CLASE: SEGURO AUTO
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionSeguroAuto {
	private LinkedList<SeguroAuto> _listaSA=new LinkedList<>();
	
	/**
     * METODO PARA BUSCAR SEGURO AUTO
     * @param seguroABuscado
     * return seguroABuscado
     */ 
	
	public SeguroAuto buscarSeguroAuto(SeguroAuto seguroAuto) {
		SeguroAuto seguroABuscado = null;
		for(int i=0; i<_listaSA.size();i++) {
			if(_listaSA.get(i).equals(seguroAuto)) {
				
				seguroABuscado = _listaSA.get(i);
			}
		}
		return seguroABuscado;
	}

	/**
     * METODO PARA AGREGAR SEGURO AUTO
     * @param seguroA
     * return seguroAEncontrado
     */ 
	
	public boolean agregarSeguroAuto(SeguroAuto agregarSeguro) {
		if(buscarSeguroAuto(agregarSeguro) == null) {
			_listaSA.add(agregarSeguro);
			return true;
		}else {
			return false;
		}
	}
	
	/**
     * METODO PARA MODIFICAR SEGURO AUTO
     * @param seguroAModificado
     * return TRUE. SI TODO SE REALIZO CORRECTAMENTE, CASO CONTRARIO RETORNARA FALSE.
     */ 
	
	public boolean modificarSeguroA(SeguroAuto seguroAModificado, int posicion ) {
		if(posicion<0 || posicion>_listaSA.size()) {
			return false;
		}else {
			if(buscarSeguroAuto(seguroAModificado) != null) {
				_listaSA.set(posicion, seguroAModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL SEGURO AUTO
	 * @param seguroAEliminado 
	 * @return true - SI TODO SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarSeguroA(SeguroAuto seguroAEliminado) {
		if(buscarSeguroAuto(seguroAEliminado) == null) {
			return false;
		}else {
			_listaSA.remove(seguroAEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaSA.size();i++) {
			System.out.println(_listaSA.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SEGURO AUTO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public SeguroAuto getPosicion(int posicion) {
		return _listaSA.get(posicion);
	}
	
}
