package gestionClases;

/*
* AUTORA: GLENY NIHIMAYA

* CLASE: GESTION SERVICIOS A PAGAR
* DESCRIPCION: OPERACIONES REALIZADAS CON ESTA CLASE.
* FECHA: 18/07/2020
*/

import java.util.LinkedList;
import clases.Servicios;

public class GestionServicios {
     private LinkedList<Servicios> listaServicios = new LinkedList<>();

	public GestionServicios() {
		super();
	}

	public LinkedList<Servicios> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(LinkedList<Servicios> listaServicios) {
		this.listaServicios = listaServicios;
	}
     
     /**
      * METODO PARA BUSCAR SERVICIO PUBLICO
      * @param 
      * return 
      */
	
	public Servicios BuscarServicio(Servicios servicios) {
		servicios = null;
		
		for(int i = 0; i < listaServicios.size(); i++) {
			if( listaServicios.get(i).equals(servicios)) {
				servicios = listaServicios.get(i);
			}
		}
		return servicios;
	}
	
	/**
	 * MÉTODO QUE AGREGAR SERVICIO PUBLICO
	 * @param servicioPagar
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarServiciosPublicos(Servicios servicioPagar) {
		
		if(BuscarServicio(servicioPagar) == null) {//Si la cuenta no esta agregada
			
			listaServicios.add(servicioPagar);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA EL SERVICIO PUBLICO
	 * @param servicioModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarServicio(Servicios servicioModificar, int posicion) {
		if(posicion<0 || posicion>listaServicios.size()) {
			return false;
		}else {
	
			if(BuscarServicio(servicioModificar) != null) {
				listaServicios.set(posicion, servicioModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL SERVICIO A PAGAR
	 * @param MONTO 
	 * @return true - SI TODOS SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarServicio(Servicios servicio) {
		
		if(BuscarServicio(servicio) == null) {
			return false;
		}else {
			listaServicios.remove(BuscarServicio(servicio));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SERVICIOS
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Servicios getPosicion(int posicion) {
		return listaServicios.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
	 */
	public void imprimirTodos() {
		for(int i = 0 ; i < listaServicios.size(); i++) {
			System.out.println(listaServicios.get(i));
		}
	} 
}
