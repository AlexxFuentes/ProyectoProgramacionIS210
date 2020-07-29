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
	private LinkedList<TransferenciasCuentasPropias> listaTransCuentas=new LinkedList<>();

	 //CONSTRUCTOR POR DEFECTO
	public GestionTransferenciasCuentasPropias() {
		super();
	}

	//GENERAR LOS SET Y GET
	public LinkedList<TransferenciasCuentasPropias> getListaTransCuentas() {
		return listaTransCuentas;
	}

	public void setListaTransCuentas(LinkedList<TransferenciasCuentasPropias> listaTransCuentas) {
		this.listaTransCuentas = listaTransCuentas;
	}
	
     /**
      * METODO PARA BUSCAR LA TRASNFERENCIA ENTRE CUENTA
      * @param
      * return
      */

	public TransferenciasCuentasPropias BuscarTrasnEntreCuentas(TransferenciasCuentasPropias trasn_entre_cuentas) {
		trasn_entre_cuentas = null;
		for(int j=0; j<listaTransCuentas.size();j++) {
			if( listaTransCuentas.get(j).equals(trasn_entre_cuentas) ) {
				trasn_entre_cuentas = listaTransCuentas.get(j);
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
		if(BuscarTrasnEntreCuentas(trasn_entre_cuentas) == null){
			listaTransCuentas.add(trasn_entre_cuentas);
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
	
	public boolean ModificarTransEntreCuentas(TransferenciasCuentasPropias tecModificado, int posicion ) {
		if(posicion<0 || posicion>listaTransCuentas.size()) {
			return false;
		}else {
			
			if(BuscarTrasnEntreCuentas(tecModificado) != null) {
				listaTransCuentas.set(posicion, tecModificado);
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
	

	public boolean EliminarTransEntreCuenta(TransferenciasCuentasPropias tecEliminado) {
		if(tecEliminado == null) {
			return false;
		}else {
			listaTransCuentas.remove(BuscarTrasnEntreCuentas(tecEliminado));
			return true;
		}
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
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
	public TransferenciasCuentasPropias getPosicion(int posicion) {
		return listaTransCuentas.get(posicion);
	}
}
