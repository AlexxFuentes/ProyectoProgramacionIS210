package gestionClases;

import java.util.LinkedList;

import clases.Pagos;
import clases.Prestamos;

/**
 * Clase: GESTION PRESTAMO
 * @author Gleny
 * DESCRIPCION: METODOS DERIVADOS A LA CLASE PRESTAMOS
 */

public class GestionPrestamos {
	//ATRIBUTO DE GESTION PRESTAMOS
	private LinkedList<Prestamos> _listaPrestamo=new LinkedList<>();


	public void setListaPrestamo(LinkedList<Prestamos> listaPrestamo) {
		this._listaPrestamo = listaPrestamo;
	}
	
	/**
     * METODO PARA BUSCAR PRESTAMO
     * @param prestamo
     * return prestamo
     */
	
	public Pagos buscarPrestamo(Prestamos prestamo) {
		prestamo = null;
		
		for(int i = 0; i < _listaPrestamo.size(); i++) {
			if( _listaPrestamo.get(i).equals(prestamo)) {
				prestamo = _listaPrestamo.get(i);
			}
		}
		return prestamo;
	}
	
	/**
	 * MÉTODO QUE AGREGAR PRESTAMO
	 * @param Prestamo
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarPago(Prestamos Prestamo) {
		
		if(buscarPrestamo(Prestamo) == null) {//Si el prestamo no esta agregado
			
			_listaPrestamo.add(Prestamo);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA EL PRESTAMO
	 * @param prestamoModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarPago(Prestamos prestamoModificar, int posicion) {
		if(posicion<0 || posicion>_listaPrestamo.size()) {
			return false;
		}else {
	
			if(buscarPrestamo(prestamoModificar) != null) {
				_listaPrestamo.set(posicion, prestamoModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL PRESTAMO
	 * @param prestamoEliminar
	 * @return true - SI TODOS SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarPrestamo(Prestamos prestamoEliminar) {
		
		if(buscarPrestamo(prestamoEliminar) == null) {
			return false;
		}else {
			_listaPrestamo.remove(buscarPrestamo(prestamoEliminar));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN PRESTAMO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Prestamos getPosicion(int posicion) {
		return _listaPrestamo.get(posicion);
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaPrestamo.size();i++) {
			System.out.println(_listaPrestamo.get(i));
		}
	}
	

}
