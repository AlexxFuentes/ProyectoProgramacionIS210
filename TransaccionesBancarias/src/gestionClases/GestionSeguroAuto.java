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
	private LinkedList<SeguroAuto> listaSA=new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionSeguroAuto() {
		super();
	}
	
	//CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionSeguroAuto(LinkedList<SeguroAuto> listaSA) {
		super();
		this.listaSA = listaSA;
	}
	
	//GETTERS Y SETTERS
	public LinkedList<SeguroAuto> getListaSA() {
		return listaSA;
	}

	public void setListaSA(LinkedList<SeguroAuto> listaSA) {
		this.listaSA = listaSA;
	}

	/**
     * METODO PARA BUSCAR SEGURO AUTO
     * @param seguroABuscado
     * return seguroABuscado
     */ 
	
	public SeguroAuto BuscarSeguroAuto(SeguroAuto seguroABuscado) {
		seguroABuscado = null;
		for(int i=0; i<listaSA.size();i++) {
			if(listaSA.get(i).equals(seguroABuscado)) {
				
				seguroABuscado = listaSA.get(i);
			}
		}
		return seguroABuscado;
	}

	/**
     * METODO PARA AGREGAR SEGURO AUTO
     * @param seguroA
     * return seguroAEncontrado
     */ 
	
	public boolean AgregarSeguroAuto(SeguroAuto agregarSeguro) {
		if(BuscarSeguroAuto(agregarSeguro) == null) {
			listaSA.add(agregarSeguro);
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
	
	public boolean ModificarSeguroA(SeguroAuto seguroAModificado, int posicion ) {
		if(posicion<0 || posicion>listaSA.size()) {
			return false;
		}else {
			if(BuscarSeguroAuto(seguroAModificado) != null) {
				listaSA.set(posicion, seguroAModificado);
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
		if(BuscarSeguroAuto(seguroAEliminado) == null) {
			return false;
		}else {
			listaSA.remove(seguroAEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaSA.size();i++) {
			System.out.println(listaSA.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SEGURO AUTO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public SeguroAuto getPosicion(int posicion) {
		return listaSA.get(posicion);
	}
	
}
