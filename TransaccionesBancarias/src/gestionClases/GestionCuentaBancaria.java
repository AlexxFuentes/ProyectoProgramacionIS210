package gestionClases;

import java.util.LinkedList;
import clases.CuentaBancaria;

/**
 * MÉTODO DE GESTIÓN DE TIPO DE CUENTA: ADMINISTRA LAS CUENTAS DEL USUARIO.
 * @author Alex Fuentes
 *
 *FECHA: 17/07/2020
 */

public class GestionCuentaBancaria {
	
	//ATRIBUTOS (COLECCIÓN)
	LinkedList<CuentaBancaria> listaTipoCuenta = new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionCuentaBancaria() {
		super();
	}
	
	//CONSTRUCTOR CON TODOS LOS CAMPOS
	public GestionCuentaBancaria(LinkedList<CuentaBancaria> listaTipoCuenta) {
		super();
		this.listaTipoCuenta = listaTipoCuenta;
	}

	/**
	 * MÉTODO QUE OBTIENE TIPO DE CUENTA DE LA COLECCIÓN
	 * @return TipoCuenta
	 */
	public LinkedList<CuentaBancaria> getTipoCuenta(){
		return listaTipoCuenta;
	}
	
	/**
	 * MÉTODO QUE BUSCA TIPO DE CUENTA
	 * @param tipocuenta
	 * @return null, SI NO SE AGREGA TIPO DE CUENTA, CASO CONTRARIO return OBJETO TIPO DE CUENTA
	 */
	
	public CuentaBancaria bucarTipoCuenta(String numeroCuenta) {
		CuentaBancaria cuentaBuscada = null;
		for(int i = 0; i < listaTipoCuenta.size(); i++) {
			if( listaTipoCuenta.get(i).get_numeroCuenta().equals(numeroCuenta)) {
				cuentaBuscada = listaTipoCuenta.get(i);
			}
		}
		return cuentaBuscada;
	}
	
	/**
	 * MÉTODO QUE AGREGA TIPO DE CUENTA
	 * @param tipocuenta
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarTipoCuenta(CuentaBancaria tipocuenta) {
		if(bucarTipoCuenta(tipocuenta.get_numeroCuenta()) == null) {//Si la cuenta no esta agregada
			listaTipoCuenta.add(tipocuenta);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA EL TIPO DE CUENTA
	 * @param tipoCuentaModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	
	public boolean ModificarTipoCuenta(CuentaBancaria tipoCuentaModificar, int posicion) {
		if(posicion<0 || posicion>listaTipoCuenta.size()) {
			return false;
		}else {
	
			if(bucarTipoCuenta(tipoCuentaModificar.get_numeroCuenta()) != null) {
				listaTipoCuenta.set(posicion, tipoCuentaModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	

	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN TIPO DE CUENTA
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public CuentaBancaria getPosicion(int posicion) {
		return listaTipoCuenta.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
	 */
	public void imprimirTodos() {
		for(int i = 0 ; i < listaTipoCuenta.size(); i++) {
			System.out.println(listaTipoCuenta.get(i));
		}
	} 
}
