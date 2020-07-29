package gestionClases;

/*
* AUTORA: GLENY NIHIMAYA

* CLASE: GESTION PAGO SERVICIOS PUBLICOS
* DESCRIPCION: MUESTRA LAS OPERACIONES QUE SE
*             PUEDEN HACER CON ESTA CLASE.
* FECHA: 18/07/2020
*/

import java.util.LinkedList;

import clases.Pagos;

public class GestionPagos {
	private LinkedList<Pagos> lstPagoServicios=new LinkedList<>();

	public GestionPagos() {
		super();
	}

	public LinkedList<Pagos> getLstPagoServicios() {
		return lstPagoServicios;
	}

	public void setLstPagoServicios(LinkedList<Pagos> lstPagoServicios) {
		this.lstPagoServicios = lstPagoServicios;
	}
       

	/*__________________FALTAN MÉTODOS________________________________*/
	
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<lstPagoServicios.size();i++) {
			System.out.println(lstPagoServicios.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN PagoServiciosPublicos
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Pagos getPosicion(int posicion) {
		return lstPagoServicios.get(posicion);
	}
}
