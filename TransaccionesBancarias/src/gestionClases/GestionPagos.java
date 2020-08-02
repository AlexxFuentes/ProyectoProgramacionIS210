package gestionClases;

/*
* AUTORA: GLENY NIHIMAYA

* CLASE: GESTION PAGO
* DESCRIPCION: MUESTRA LAS OPERACIONES QUE SE
*             PUEDEN HACER CON ESTA CLASE.
* FECHA: 18/07/2020
*/

import java.util.LinkedList;

import clases.Pagos;


public class GestionPagos {
	private LinkedList<Pagos> _lstPagoServicios=new LinkedList<>();

	
	/**
     * METODO PARA BUSCAR PAGO
     * @param pago
     * return pago
     */
	
	public Pagos buscarPago(Pagos pago) {
		Pagos pagobuscado = null;
		
		for(int i = 0; i < _lstPagoServicios.size(); i++) {
			if( _lstPagoServicios.get(i).equals(pago)) {
				pagobuscado = _lstPagoServicios.get(i);
			}
		}
		return pagobuscado;
	}
	
	/**
	 * M�TODO QUE AGREGAR PAGO
	 * @param PagoRealizar
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean agregarPago(Pagos PagoRealizar) {
		
		if(buscarPago(PagoRealizar) == null) {//Si el pago no esta agregado
			
			_lstPagoServicios.add(PagoRealizar);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * M�TODO QUE MODIFICA EL PAGO
	 * @param pagoModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean modificarPago(Pagos pagoModificar, int posicion) {
		if(posicion<0 || posicion>_lstPagoServicios.size()) {
			return false;
		}else {
	
			if(buscarPago(pagoModificar) != null) {
				_lstPagoServicios.set(posicion, pagoModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL PAGO
	 * @param pagoEliminar
	 * @return true - SI TODOS SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean eliminarPago(Pagos pagoEliminar) {
		
		if(buscarPago(pagoEliminar) == null) {
			return false;
		}else {
			_lstPagoServicios.remove(buscarPago(pagoEliminar));
			return true;
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N PAGO
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public Pagos getPosicion(int posicion) {
		return _lstPagoServicios.get(posicion);
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<_lstPagoServicios.size();i++) {
			System.out.println(_lstPagoServicios.get(i));
		}
	}
	
}
