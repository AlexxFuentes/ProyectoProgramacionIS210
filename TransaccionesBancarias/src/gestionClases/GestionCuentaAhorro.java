package gestionClases;

import java.util.LinkedList;

import clases.CuentaAhorro;
/**
 * GESTI�N CUENTA DE AHORRO: OPERACIONES QUE SE REALIZAN
 * @author Alex Fuentes
 *
 *FECHA 17/07/2020
 */
public class GestionCuentaAhorro {
	
	//ATRIBUTOS (COLECCI�N)
	private LinkedList<CuentaAhorro> _listaCuentaAhorro = new LinkedList<>();
	
	/**
	 * M�TODO QUE OBTIENE UN CUENTA AHORRO DE LA COLECCI�N
	 * @return listaCuentaAhorro
	 */
	public LinkedList<CuentaAhorro> getCuentaAhorro(){
		return _listaCuentaAhorro;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA DE AHORRO POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA AHORRO, CASO CONTRARIO return CuentaAhorroBuscada
	 */
	public CuentaAhorro buscarCuentaAhorro(int numCuenta) {
		CuentaAhorro CuentaAhorroBuscada = null;
		for(int i = 0; i < _listaCuentaAhorro.size(); i++) {
			if( _listaCuentaAhorro.get(i).get_numeroCuenta() == numCuenta) {
				CuentaAhorroBuscada = _listaCuentaAhorro.get(i);
			}
		}
		return CuentaAhorroBuscada;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA DE AHORRO POR RTN DEL TITULAR DE LA CUENTA
	 * @param RTN
	 * @return null - SI NO ENCUENTRA LA CUENTA DE AHORRO, CASO CONTRARIO return CuentaAhorroBuscada
	 */
	public CuentaAhorro buscarCuentaAhorro(String RTN) {
		CuentaAhorro CuentaAhorroBuscada = null;
		for(int i = 0; i < _listaCuentaAhorro.size(); i++) {
			if( _listaCuentaAhorro.get(i).get_titular().get_rtn().equals(RTN)) {
				CuentaAhorroBuscada = _listaCuentaAhorro.get(i);
			}
		}
		return CuentaAhorroBuscada;
	}
	
	
	/**
	 * M�TODO PARA AGREFAR NUEVA CUENTA DE AHORRO
	 * @param cuentaAhorro
	 * @return true - SI SE AGREGO CORRECTAMENTE LA CUENTA_AHORRO, CASO CONTRARIO return false.
	 */
	public boolean agregarCuentaAhorro(CuentaAhorro cuentaAhorro) {
		if(buscarCuentaAhorro(cuentaAhorro.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			_listaCuentaAhorro.add(cuentaAhorro);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * M�TODO PARA ELIMINAR CUENTA_AHORRO POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return false - SI NO SE ENCONTRO LA CUENTA_AHORRO, CASO CONTRARIO return true.
	 */
	public boolean eliminarCuentaAhorro(CuentaAhorro CuentaAhorro) {
		if(buscarCuentaAhorro(CuentaAhorro.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			_listaCuentaAhorro.remove(CuentaAhorro);//ELIMINA CUENTA_AHORRO ENCONTRADO
			return true;
		}
	}
	
	/**
	 * M�TODO PARA MODIFICAR CUENTA_AHORRO EN LA COLECCI�N
	 * @param CuentaAhorroModificado
	 * @param posicion
	 * @return false - SI NO LO ENCUENTRA EN LA COLECCION, CASO CONTRARIO return true (CUENTA_AHORRO MODIFICADO)
	 */
	public boolean modificarCuentaAhorro(CuentaAhorro CuentaAhorroModificado, int posicion) {
		
		if(posicion<0 || posicion>_listaCuentaAhorro.size()) {
			return false;
		}else {
			
			if(buscarCuentaAhorro(CuentaAhorroModificado.get_numeroCuenta()) != null) {
				_listaCuentaAhorro.set(posicion, CuentaAhorroModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N CUENTA_AHORRO
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public CuentaAhorro getPosicion(int posicion) {
		return _listaCuentaAhorro.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaCuentaAhorro.size();i++) {
			System.out.println(_listaCuentaAhorro.get(i));
		}
	}
	
	public double interesRemunerados(double Monto) {
		double Interesesremunerados = 0;
		
		if(Monto >= 0 || Monto <= 999.99 ) {
			Interesesremunerados = (Monto*(0.0005)); 
			return Interesesremunerados;
		} else if(Monto >= 1000 || Monto <= 9999.99 ) {
			Interesesremunerados =  (Monto*(0.0075)); 
			return Interesesremunerados;
		} else if(Monto >= 10000 || Monto <= 24999.99 ) {
			Interesesremunerados =  (Monto*(0.01)); 
			return Interesesremunerados;
		} else if(Monto >= 25000 || Monto <= 49999.99 ) {
			Interesesremunerados = (Monto*(0.0126)); 
			return Interesesremunerados;
		} else if(Monto >= 50000 || Monto <= 99999.99 ) {
			Interesesremunerados = Monto + (Monto*(0.0151)); 
			return Interesesremunerados;
		} else if(Monto >= 100000 || Monto <= 249999.99 ) {
			Interesesremunerados = (Monto*(0.0176)); 
			return Interesesremunerados;
		} else if(Monto >= 250000 || Monto <= 499999.99 ) {
			Interesesremunerados = (Monto*(0.0176)); 
			return Interesesremunerados;
		} else if(Monto >= 500000 || Monto <= 999999.99 ) {
			Interesesremunerados = (Monto*(0.0176)); 
			return Interesesremunerados;
		} else if(Monto >= 1000000 || Monto <= 1999999.99 ) {
			Interesesremunerados = (Monto*(0.0176)); 
			return Interesesremunerados;
		} else if(Monto >= 2000000 || Monto > 2000000 ) {
			Interesesremunerados =   (Monto*(0.0176)); 
			return Interesesremunerados;
		}else {
			return Interesesremunerados;
		}
	}
	
}
