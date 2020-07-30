package gestionClases;

/*
* AUTORA: GLENY NIHIMAYA

* CLASE: GESTION TRANSFERENCIAS INTERBANCARIAS
* DESCRIPCION: PERMITE QUE EL USUARIO REALICE UNA
*              TRANSFERENCIA INTERBANCARIA.
* FECHA: 18/07/2020
*/

import java.util.LinkedList;

import clases.TransferenciasACH;

public class GestionTransferenciasACH {
	//COLECCION
		private LinkedList<TransferenciasACH> _listaTransaccionesACH = new LinkedList<>();

	      /**
	       * METODO PARA BUSCAR LA TRASNFERENCIA ENTRE CUENTA
	       * @param
	       * return
	       */
		

		public TransferenciasACH buscarTACH(TransferenciasACH transferenciaach) {
			TransferenciasACH transEncontrado = null;
			for(int j=0; j<_listaTransaccionesACH.size();j++) {
				if(_listaTransaccionesACH.get(j).equals(transEncontrado)) {
					transEncontrado = _listaTransaccionesACH.get(j);
				}
			}
			return transEncontrado;
		}
		
		/**
	     * METODO PARA AGREGAR LA TRASNFERENCIA ENTRE CUENTA
	     * @param tec
	     * return
	     */
		
		public boolean agregarTACH(TransferenciasACH transferncia) {
			if(buscarTACH(transferncia) == null){
				_listaTransaccionesACH.add(transferncia);
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
		
		public boolean ModificarTEC(TransferenciasACH tecModificado, int posicion ) {
			if(posicion<0 || posicion>_listaTransaccionesACH.size()) {
				return false;
			}else {
				
				if(buscarTACH(tecModificado) != null) {
					_listaTransaccionesACH.set(posicion, tecModificado);
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

		public boolean EliminarTI(TransferenciasACH transEliminar) {
			if(buscarTACH(transEliminar) == null) {
				return false;
			}else {
				_listaTransaccionesACH.remove(buscarTACH(transEliminar));
		     	return true;
		    }
		}
		
		/**
		 * METODO PARA IMPRIMIR TODO
		 */
		public void imprimirTodos() {
			for(int i=0;i<_listaTransaccionesACH.size();i++) {
				System.out.println(_listaTransaccionesACH.get(i));
			}
		}
		
		/**
		 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN DEPOSITAR
		 * @param posicion
		 * @return POSICIÓN O INDICE DE LA COLECIÓN
		 */
		public TransferenciasACH getPosicion(int posicion) {
			return _listaTransaccionesACH.get(posicion);
		}
		
		public String getCodigoTACH() {
			String _codigoTACH =  "TACH_" + _listaTransaccionesACH.size() + 1;
			
			return _codigoTACH;
		}
		
}
