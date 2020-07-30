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
	private LinkedList<SeguroMedico> listaSM=new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionSeguroMedico() {
		super();
	}
	
	//CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionSeguroMedico(LinkedList<SeguroMedico> listaSM) {
		super();
		this.listaSM = listaSM;
	}

	//GETTERS Y SETTERS
	public LinkedList<SeguroMedico> getListaSM() {
		return listaSM;
	}

	public void setListaSM(LinkedList<SeguroMedico> listaSM) {
		this.listaSM = listaSM;
	}

	/**
     * METODO PARA BUSCAR SEGURO MEDICO
     * @param seguroMBuscado
     * return seguroMBuscado
     */ 
	
	public SeguroMedico BuscarSeguroMedico(SeguroMedico seguroMBuscado) {
		seguroMBuscado = null;
		for(int i=0; i<listaSM.size();i++) {
			if(listaSM.get(i).equals(seguroMBuscado)) {
				
				seguroMBuscado = listaSM.get(i);
			}
		}
		return seguroMBuscado;
	}

	/**
     * METODO PARA AGREGAR SEGURO MEDICO
     * @param agregarSeguro
     * return seguroAEncontrado
     */ 
	
	public boolean AgregarSeguroMedico(SeguroMedico agregarSeguro) {
		if(BuscarSeguroMedico(agregarSeguro) == null) {
			listaSM.add(agregarSeguro);
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
	
	public boolean ModificarSeguroM(SeguroMedico seguroMModificado, int posicion ) {
		if(posicion<0 || posicion>listaSM.size()) {
			return false;
		}else {
			if(BuscarSeguroMedico(seguroMModificado) != null) {
				listaSM.set(posicion, seguroMModificado);
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
	
	public boolean EliminarSeguroM(SeguroMedico seguroMEliminado) {
		if(BuscarSeguroMedico(seguroMEliminado) == null) {
			return false;
		}else {
			listaSM.remove(seguroMEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaSM.size();i++) {
			System.out.println(listaSM.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SEGURO MEDICO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public SeguroMedico getPosicion(int posicion) {
		return listaSM.get(posicion);
	}
}
