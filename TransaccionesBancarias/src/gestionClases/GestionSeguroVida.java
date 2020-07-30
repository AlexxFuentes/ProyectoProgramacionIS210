package gestionClases;

import java.util.LinkedList;

import clases.SeguroVida;

/**
 * CLASE: SEGUROVIDA
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionSeguroVida {
	//ATRIBUTO DE GESTION SEGURO VIDA
	private LinkedList<SeguroVida> listaSV=new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionSeguroVida() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionSeguroVida(LinkedList<SeguroVida> listaSV) {
		super();
		this.listaSV = listaSV;
	}

    //GETTERS Y SETTERS
	public LinkedList<SeguroVida> getListaSV() {
		return listaSV;
	}

	public void setListaSV(LinkedList<SeguroVida> listaSV) {
		this.listaSV = listaSV;
	}

	/**
     * METODO PARA BUSCAR SEGURO VIDA
     * @param seguroVBuscado
     * return seguroVBuscado
     */ 
	
	public SeguroVida BuscarSeguroVida(SeguroVida seguroVBuscado) {
		seguroVBuscado = null;
		for(int i=0; i<listaSV.size();i++) {
			if(listaSV.get(i).equals(seguroVBuscado)) {
				
				seguroVBuscado = listaSV.get(i);
			}
		}
		return seguroVBuscado;
	}

	/**
     * METODO PARA AGREGAR SEGURO VIDA
     * @param agregarSeguro
     * return seguroVEncontrado
     */ 
	
	public boolean AgregarSeguroVida(SeguroVida agregarSeguro) {
		if(BuscarSeguroVida(agregarSeguro) == null) {
			listaSV.add(agregarSeguro);
			return true;
		}else {
			return false;
		}
	}
	
	/**
     * METODO PARA MODIFICAR SEGURO VIDA
     * @param seguroVModificado
     * return TRUE. SI TODO SE REALIZO CORRECTAMENTE, CASO CONTRARIO RETORNARA FALSE.
     */ 
	
	public boolean ModificarSeguroM(SeguroVida seguroVModificado, int posicion ) {
		if(posicion<0 || posicion>listaSV.size()) {
			return false;
		}else {
			if(BuscarSeguroVida(seguroVModificado) != null) {
				listaSV.set(posicion, seguroVModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL SEGURO VIDA
	 * @param seguroVEliminado 
	 * @return true - SI TODO SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarSeguroV(SeguroVida seguroVEliminado) {
		if(BuscarSeguroVida(seguroVEliminado) == null) {
			return false;
		}else {
			listaSV.remove(seguroVEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaSV.size();i++) {
			System.out.println(listaSV.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SEGURO MEDICO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public SeguroVida getPosicion(int posicion) {
		return listaSV.get(posicion);
	}
}
