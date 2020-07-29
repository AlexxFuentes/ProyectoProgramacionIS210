package gestionClases;

import java.util.LinkedList;
import clases.Seguros;


public class GestionSeguros {
	//COLECCIÓN
      private LinkedList<Seguros> listaSeguros = new LinkedList<>();

      //CONSTRUCTOR POR DEFECTO
	public GestionSeguros() {
		super();
	}
    
	//GENERADOR DEL GET
	public LinkedList<Seguros> getListaSeguros() {
		return listaSeguros;
	}

	//GENERADOR DEL SET
	public void setListaSeguros(LinkedList<Seguros> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}
      
    /**
     * METODO PARA BUSCAR SEGURO
     * @param seguro
     * return seguroEncontrado
     */ 
	
	public Seguros BuscarSeguro(Seguros seguroBuscado) {
		seguroBuscado = null;
		for(int i=0; i<listaSeguros.size();i++) {
			if(listaSeguros.get(i).equals(seguroBuscado)) {
				
				seguroBuscado = listaSeguros.get(i);
			}
		}
		return seguroBuscado;
	}
	
	/**
     * METODO PARA AGREGAR SEGURO
     * @param seguro
     * return seguroEncontrado
     */ 
	
	public boolean AgregarSeguro(Seguros agregarSeguro) {
		if(BuscarSeguro(agregarSeguro) == null) {
			listaSeguros.add(agregarSeguro);
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
	
	public boolean ModificarSeguro(Seguros seguroModificado, int posicion ) {
		if(posicion<0 || posicion>listaSeguros.size()) {
			return false;
		}else {
			if(BuscarSeguro(seguroModificado) != null) {
				listaSeguros.set(posicion, seguroModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL DEPOSITO
	 * @param MONTO 
	 * @return true - SI TODO SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarSeguro(Seguros seguroEliminado) {
		if(BuscarSeguro(seguroEliminado) == null) {
			return false;
		}else {
			listaSeguros.remove(seguroEliminado);
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODO
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaSeguros.size();i++) {
			System.out.println(listaSeguros.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN DEPOSITAR
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Seguros getPosicion(int posicion) {
		return listaSeguros.get(posicion);
	}
	
	
}
