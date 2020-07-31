package gestionClases;

import java.util.LinkedList;
import clases.CuentaBancaria;

/**
 * M�TODO DE GESTI�N DE TIPO DE CUENTA: ADMINISTRA LAS CUENTAS DEL USUARIO.
 * @author Alex Fuentes
 *
 *FECHA: 17/07/2020
 */

public class GestionCuentaBancaria {
	
	//ATRIBUTOS (COLECCI�N)
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
	 * M�TODO QUE OBTIENE TIPO DE CUENTA DE LA COLECCI�N
	 * @return TipoCuenta
	 */
	public LinkedList<CuentaBancaria> getTipoCuenta(){
		return listaTipoCuenta;
	}
	
	/**
	 * M�TODO QUE BUSCA TIPO DE CUENTA
	 * @param tipocuenta
	 * @return null, SI NO SE AGREGA TIPO DE CUENTA, CASO CONTRARIO return OBJETO TIPO DE CUENTA
	 */
	
	public CuentaBancaria bucarTipoCuenta(int numeroCuenta) {
		CuentaBancaria cuentaBuscada = null;
		for(int i = 0; i < listaTipoCuenta.size(); i++) {
			if( listaTipoCuenta.get(i).get_numeroCuenta() == numeroCuenta) {
				cuentaBuscada = listaTipoCuenta.get(i);
			}
		}
		return cuentaBuscada;
	}
	
	public CuentaBancaria bucarTipoCuenta(String RTN) {
		CuentaBancaria cuentaBuscada = null;
		for(int i = 0; i < listaTipoCuenta.size(); i++) {
			if( listaTipoCuenta.get(i).get_titular().get_rtn().equals(RTN)) {
				cuentaBuscada = listaTipoCuenta.get(i);
			}
		}
		return cuentaBuscada;
	}
	
	/**
	 * M�TODO QUE AGREGA TIPO DE CUENTA
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
	 * M�TODO QUE MODIFICA EL TIPO DE CUENTA
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
	
	public boolean eliminarTipoCuenta(CuentaBancaria tipocuenta) {
		if(bucarTipoCuenta(tipocuenta.get_numeroCuenta()) == null) {
			return false;
		}else {
			listaTipoCuenta.remove(tipocuenta);
			return true;
		}
	}
	

	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N TIPO DE CUENTA
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public CuentaBancaria getPosicion(int posicion) {
		return listaTipoCuenta.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i = 0 ; i < listaTipoCuenta.size(); i++) {
			System.out.println(listaTipoCuenta.get(i));
		}
	} 
	
	
	public int generaNumeroCuenta() {
		int [] Cuenta1 = {10,20,30,40,50,60,70,80,90,00};
		
		int numCuenta = 2020 + (int)(Math.random() * Cuenta1.length) + (int)(Math.random() * Cuenta1.length) 
				                  + (int)(Math.random() * Cuenta1.length)+(int)(Math.random() * Cuenta1.length)
				                  + (int)(Math.random() * Cuenta1.length);
		return numCuenta;
	}
}
