package gestionClases;

import java.util.LinkedList;

import clases.CuentaCorrientePersonal;

/**
 * GESTI�N CUENTA CORRIENTE PERSONAL: OPERACIONES QUE SE REALIZAN
 * @author Alex Fuentes
 *
 *FECHA: 18/07/2020
 */

public class GestionCuentaCorrientePersonal {
	
	//ATRIBUTOS (COLECCI�N)
	private LinkedList<CuentaCorrientePersonal> _listaCuentaCorrientePersonal = new LinkedList<>();

	/**
	 * M�TODO QUE OBTIENE UN CUENTA_CORRIENTE_PERSONAL DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<CuentaCorrientePersonal> getCuentaCorrientePersonal(){
		return _listaCuentaCorrientePersonal;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA_CORRIENTE_PERSONAL POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA_CORRIENTE_PERSONAL, CASO CONTRARIO RETORNA OBJ.CUENTA_CORRIENTE_PERSONAL
	 */
	public CuentaCorrientePersonal buscarCuentaCorrientePersonal(int numCuenta) {
		CuentaCorrientePersonal CuentaCorrientePersonalBuscada = null;
		for(int i = 0; i < _listaCuentaCorrientePersonal.size(); i++) {
			if( _listaCuentaCorrientePersonal.get(i).get_numeroCuenta() == numCuenta) {
				CuentaCorrientePersonalBuscada = _listaCuentaCorrientePersonal.get(i);
			}
		}
		return CuentaCorrientePersonalBuscada;
	}
	
	/**
	 * M�TODO PARA AGREFAR NUEVA CUENTA_CORRIENTE_PERSONAL
	 * @param cuentaCorrientePersonal
	 * @return true - SI SE AGREGO CORRECTAMENTE LA CUENTA_CORRIENTE_PERSONAL, CASO CONTRARIO return false.
	 */
	public boolean AgregarCuentaCorrientePersonal(CuentaCorrientePersonal cuentaCorrientePersonal) {
		if(buscarCuentaCorrientePersonal(cuentaCorrientePersonal.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			_listaCuentaCorrientePersonal.add(cuentaCorrientePersonal);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * M�TODO PARA ELIMINAR CUENTA_CORRIENTE_PERSONAL POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return false - SI NO SE ENCONTRO LA CUENTA_CORRIENTE_PERSONAL, CASO CONTRARIO return true.
	 */
	public boolean EliminarCuentaAhorro(CuentaCorrientePersonal CuentaCorriPersonal) {
		if(buscarCuentaCorrientePersonal(CuentaCorriPersonal.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			_listaCuentaCorrientePersonal.remove(CuentaCorriPersonal);//ELIMINA CUENTA_AHORRO ENCONTRADO
			return true;
		}
	}
	
	/**
	 * M�TODO PARA MODIFICAR CUENTA_CORRIENTE_PERSONAL EN LA COLECCI�N
	 * @param CuentaCorrientePerModificado
	 * @param posicion
	 * @return false - SI NO LO ENCUENTRA EN LA COLECCION, CASO CONTRARIO return true (CUENTA_CORRIENTE_PERSONAL MODIFICADO)
	 */
	public boolean ModificarCuentaAhorro(CuentaCorrientePersonal CuentaCorrientePerModificado, int posicion) {
		
		if(posicion<0 || posicion>_listaCuentaCorrientePersonal.size()) {
			return false;
		}else {
			
			if(buscarCuentaCorrientePersonal(CuentaCorrientePerModificado.get_numeroCuenta()) != null) {
				_listaCuentaCorrientePersonal.set(posicion, CuentaCorrientePerModificado);
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
	public CuentaCorrientePersonal getPosicion(int posicion) {
		return _listaCuentaCorrientePersonal.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaCuentaCorrientePersonal.size();i++) {
			System.out.println(_listaCuentaCorrientePersonal.get(i));
		}
	}
}
