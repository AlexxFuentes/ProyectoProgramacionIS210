package gestionClases;

/*
* AUTORA: GLENY NIHIMAYA

* CLASE: GESTION TRANSFERENCIAS ENTRE CUENTAS
* DESCRIPCION: PERMITE QUE EL USUARIO HAGA LAS
*              TRANSFERENCIAS ENTRE CUENTA.
* FECHA: 18/07/2020
*/

import java.util.LinkedList;


import clases.TransferenciasCuentasPropias;

public class GestionTransferenciasCuentasPropias {
      //COLECCION
	private LinkedList<TransferenciasCuentasPropias> _listaTransCuentas=new LinkedList<>();

     /**
      * METODO PARA BUSCAR LA TRASNFERENCIA ENTRE CUENTA
      * @param
      * return
      */

	public TransferenciasCuentasPropias buscarTrasnEntreCuentas(TransferenciasCuentasPropias trasn_entre_cuentas) {
		trasn_entre_cuentas = null;
		for(int j=0; j<_listaTransCuentas.size();j++) {
			if( _listaTransCuentas.get(j).equals(trasn_entre_cuentas) ) {
				trasn_entre_cuentas = _listaTransCuentas.get(j);
			}
		}
		return trasn_entre_cuentas;
	}
	
	/**
     * METODO PARA AGREGAR LA TRASNFERENCIA ENTRE CUENTA
     * @param
     * return
     */
	public boolean agregarTrasEntreCuentas(TransferenciasCuentasPropias trasn_entre_cuentas) {
		if(buscarTrasnEntreCuentas(trasn_entre_cuentas) == null){
			_listaTransCuentas.add(trasn_entre_cuentas);
			return true;
		} else {
			return false;
		}
	}
	
	/**
     * METODO PARA AGREGAR LA TRASNFERENCIA ENTRE CUENTA
     * @param
     * return
     */
	
	public boolean modificarTransEntreCuentas(TransferenciasCuentasPropias tecModificado, int posicion ) {
		if(posicion<0 || posicion>_listaTransCuentas.size()) {
			return false;
		}else {
			
			if(buscarTrasnEntreCuentas(tecModificado) != null) {
				_listaTransCuentas.set(posicion, tecModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR EL DEPOSITO
	 * @param MONTO 
	 * @return true - SI TODOs SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	

	public boolean eliminarTransEntreCuenta(TransferenciasCuentasPropias tecEliminado) {
		if(tecEliminado == null) {
			return false;
		}else {
			_listaTransCuentas.remove(buscarTrasnEntreCuentas(tecEliminado));
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaTransCuentas.size();i++) {
			System.out.println(_listaTransCuentas.get(i));
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN DEPOSITAR
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public TransferenciasCuentasPropias getPosicion(int posicion) {
		return _listaTransCuentas.get(posicion);
	}
	
	
	public String getCodigoTECP() {
		String _codigoTECP =  "TECP_" + _listaTransCuentas.size() + 1;
		
		return _codigoTECP;
	}
}
