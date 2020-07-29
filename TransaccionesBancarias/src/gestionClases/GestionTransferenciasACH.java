package gestionClases;

/*
* AUTORA: GLENY NIHIMAYA

* CLASE: GESTION TRANSFERENCIAS INTERBANCARIAS
* DESCRIPCION: PERMITE QUE EL USUARIO REALICE UNA
*              TRANSFERENCIA INTERBANCARIA.
* FECHA: 18/07/2020
*/

import java.util.LinkedList;

import clases.TransferenciasInternacionales;

public class GestionTransferenciasACH {
	//COLECCION
		private LinkedList<TransferenciasInternacionales> listaTransCuentas = new LinkedList<>();

	      /**
	       * METODO PARA BUSCAR LA TRASNFERENCIA ENTRE CUENTA
	       * @param
	       * return
	       */
		

		public TransferenciasInternacionales BuscarTI(TransferenciasInternacionales transEncontrado) {
			transEncontrado = null;
			for(int j=0; j<listaTransCuentas.size();j++) {
				if(listaTransCuentas.get(j).equals(transEncontrado)) {
					transEncontrado = listaTransCuentas.get(j);
				}
			}
			return transEncontrado;
		}
		
		/**
	     * METODO PARA AGREGAR LA TRASNFERENCIA ENTRE CUENTA
	     * @param tec
	     * return
	     */
		
		public boolean agregarTEC(TransferenciasInternacionales transferncia) {
			if(BuscarTI(transferncia) == null){
				listaTransCuentas.add(transferncia);
				return true;
			}else {
				return false;
			}
		}
		
		/**
	     * METODO PARA MODIFICAR LA TRASNFERENCIA ENTRE CUENTA
	     * @param tecModificado
	     * @param posicion
	     * return
	     */
		
		public boolean ModificarTEC(TransferenciasInternacionales tecModificado, int posicion ) {
			if(posicion<0 || posicion>listaTransCuentas.size()) {
				return false;
			}else {
				
				if(BuscarTI(tecModificado) != null) {
					listaTransCuentas.set(posicion, tecModificado);
					return true;
				}else {
					return false;
				}
			}
		}
		
		/**
	     * METODO PARA ELIMINAR LA TRASNFERENCIA ENTRE CUENTA
	     * @param transEliminar
	     * return
	     */

		public boolean EliminarTI(TransferenciasInternacionales transEliminar) {
			if(BuscarTI(transEliminar) == null) {
				return false;
			}else {
				listaTransCuentas.remove(BuscarTI(transEliminar));
		     	return true;
		    }
		}
		
		/**
		 * METODO PARA IMPRIMIR TODO
		 */
		public void imprimirTodos() {
			for(int i=0;i<listaTransCuentas.size();i++) {
				System.out.println(listaTransCuentas.get(i));
			}
		}
		
		/**
		 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN DEPOSITAR
		 * @param posicion
		 * @return POSICIÓN O INDICE DE LA COLECIÓN
		 */
		public TransferenciasInternacionales getPosicion(int posicion) {
			return listaTransCuentas.get(posicion);
		}
}
