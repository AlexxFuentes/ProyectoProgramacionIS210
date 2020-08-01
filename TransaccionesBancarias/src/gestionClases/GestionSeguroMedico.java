package gestionClases;

import java.util.LinkedList;

import clases.SeguroMedico;

/**
 * CLASE: SEGURO MEDICO
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionSeguroMedico {
	
	//ATRIBUTO DE LA GESTION SEGURO MEDICO
	private LinkedList<SeguroMedico> _listaSM=new LinkedList<>();
	
	/**
     * METODO PARA BUSCAR SEGURO MEDICO
     * @param seguroMBuscado
     * return seguroMBuscado
     */ 
	
	public SeguroMedico buscarSeguroMedico(SeguroMedico seguroMBuscado) {
		seguroMBuscado = null;
		for(int i=0; i<_listaSM.size();i++) {
			if(_listaSM.get(i).equals(seguroMBuscado)) {
				
				seguroMBuscado = _listaSM.get(i);
			}
		}
		return seguroMBuscado;
	}

	/**
     * METODO PARA AGREGAR SEGURO MEDICO
     * @param agregarSeguro
     * return seguroAEncontrado
     */ 
	
	public boolean agregarSeguroMedico(SeguroMedico agregarSeguro) {
		if(buscarSeguroMedico(agregarSeguro) == null) {
			_listaSM.add(agregarSeguro);
			return true;
		}else {
			return false;
		}
	}
	
	/**
     * METODO PARA MODIFICAR SEGURO MEDICO
     * @param seguroMModificado
     * return TRUE. SI TODO SE REALIZO CORRECTAMENTE, CASO CONTRARIO RETORNARA FALSE.
     */ 
	
	public boolean modificarSeguroM(SeguroMedico seguroMModificado, int posicion ) {
		if(posicion<0 || posicion>_listaSM.size()) {
			return false;
		}else {
			if(buscarSeguroMedico(seguroMModificado) != null) {
				_listaSM.set(posicion, seguroMModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL SEGURO MEDICO
	 * @param seguroMEliminado 
	 * @return true - SI TODO SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean eliminarSeguroM(SeguroMedico seguroMEliminado) {
		if(buscarSeguroMedico(seguroMEliminado) == null) {
			return false;
		}else {
			_listaSM.remove(seguroMEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaSM.size();i++) {
			System.out.println(_listaSM.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SEGURO MEDICO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public SeguroMedico getPosicion(int posicion) {
		return _listaSM.get(posicion);
	}
}
