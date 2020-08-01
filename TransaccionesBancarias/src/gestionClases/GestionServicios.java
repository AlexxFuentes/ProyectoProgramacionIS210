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
     private LinkedList<Servicios> _listaServicios = new LinkedList<>();

	public GestionServicios() {
		super();
	}

	public LinkedList<Servicios> getListaServicios() {
		return _listaServicios;
	}
     
     /**
      * METODO PARA BUSCAR SERVICIO PUBLICO
      * @param 
      * return 
      */
	
	public Servicios buscarServicio(Servicios servicios) {
		Servicios servicioBuscado = null;
		
		for(int i = 0; i < _listaServicios.size(); i++) {
			if( _listaServicios.get(i).equals(servicios)) {
				servicioBuscado = _listaServicios.get(i);
			}
		}
		return servicioBuscado;
	}
	
	/**
	 * MÉTODO QUE AGREGAR SERVICIO PUBLICO
	 * @param servicioPagar
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean agregarServiciosPublicos(Servicios servicioPagar) {
		
		if(buscarServicio(servicioPagar) == null) {//Si la cuenta no esta agregada
			
			_listaServicios.add(servicioPagar);
			
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
	public boolean modificarServicio(Servicios servicioModificar, int posicion) {
		if(posicion<0 || posicion>_listaServicios.size()) {
			return false;
		}else {
	
			if(buscarServicio(servicioModificar) != null) {
				_listaServicios.set(posicion, servicioModificar);
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
	
	public boolean eliminarServicio(Servicios servicio) {
		
		if(buscarServicio(servicio) == null) {
			return false;
		}else {
			_listaServicios.remove(buscarServicio(servicio));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN SERVICIOS
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Servicios getPosicion(int posicion) {
		return _listaServicios.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
	 */
	public void imprimirTodos() {
		for(int i = 0 ; i < _listaServicios.size(); i++) {
			System.out.println(_listaServicios.get(i));
		}
	} 
}
