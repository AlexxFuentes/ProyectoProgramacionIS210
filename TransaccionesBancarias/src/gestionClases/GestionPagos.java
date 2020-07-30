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
	private LinkedList<Pagos> lstPagoServicios=new LinkedList<>();

	//CONSTRUCTOR POR DEFECTO
	public GestionPagos() {
		super();
	}

	//CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionPagos(LinkedList<Pagos> lstPagoServicios) {
		super();
		this.lstPagoServicios = lstPagoServicios;
	}

	//GETTERS Y SETTERS
	public LinkedList<Pagos> getLstPagoServicios() {
		return lstPagoServicios;
	}

	public void setLstPagoServicios(LinkedList<Pagos> lstPagoServicios) {
		this.lstPagoServicios = lstPagoServicios;
	}

	
	/**
     * METODO PARA BUSCAR PAGO
     * @param pago
     * return pago
     */
	
	public Pagos BuscarPago(Pagos pago) {
		pago = null;
		
		for(int i = 0; i < lstPagoServicios.size(); i++) {
			if( lstPagoServicios.get(i).equals(pago)) {
				pago = lstPagoServicios.get(i);
			}
		}
		return pago;
	}
	
	/**
	 * MÉTODO QUE AGREGAR PAGO
	 * @param PagoRealizar
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarPago(Pagos PagoRealizar) {
		
		if(BuscarPago(PagoRealizar) == null) {//Si el pago no esta agregado
			
			lstPagoServicios.add(PagoRealizar);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA EL PAGO
	 * @param pagoModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarPago(Pagos pagoModificar, int posicion) {
		if(posicion<0 || posicion>lstPagoServicios.size()) {
			return false;
		}else {
	
			if(BuscarPago(pagoModificar) != null) {
				lstPagoServicios.set(posicion, pagoModificar);
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
	
	public boolean EliminarPago(Pagos pagoEliminar) {
		
		if(BuscarPago(pagoEliminar) == null) {
			return false;
		}else {
			lstPagoServicios.remove(BuscarPago(pagoEliminar));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN PAGO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Pagos getPosicion(int posicion) {
		return lstPagoServicios.get(posicion);
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<lstPagoServicios.size();i++) {
			System.out.println(lstPagoServicios.get(i));
		}
	}
	
}
