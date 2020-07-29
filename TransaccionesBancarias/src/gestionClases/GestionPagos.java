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
       

	/*__________________FALTAN M�TODOS________________________________*/
	
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<lstPagoServicios.size();i++) {
			System.out.println(lstPagoServicios.get(i));
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N PagoServiciosPublicos
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public Pagos getPosicion(int posicion) {
		return lstPagoServicios.get(posicion);
	}
}
