package gestionClases;

import java.util.LinkedList;
import clases.CuentaNomina;

/**
 * GESTI�N DE CUENTA_NOMINA: OPERACIONES QUE SE PUEDEN REALIZAR
 * @author Alex Fuentes
 *
 *FECHA: 18/07/2020
 */
public class GestionCuentaNomina {
	
	//ATRIBUTOS (COLECCI�N)
	private LinkedList<CuentaNomina> _listaCuentaNomina = new LinkedList<>();
	
	/**
	 * M�TODO QUE OBTIENE UNA CUENTA_NOMINA DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<CuentaNomina> getCuentaCheques(){
		return _listaCuentaNomina;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA_NOMINA POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA_NOMINA, CASO CONTRARIO RETORNA OBJ.CUENTA_NOMINA
	 */
	public CuentaNomina buscarCuentaNomina(int numCuenta) {
		CuentaNomina CuentaNominaBuscada = null;
		for(int i = 0; i < _listaCuentaNomina.size(); i++) {
			if( _listaCuentaNomina.get(i).get_numeroCuenta() == numCuenta) {
				CuentaNominaBuscada = _listaCuentaNomina.get(i);
			}
		}
		return CuentaNominaBuscada;
	}
	
	/**
	 * M�TODO PARA AGREFAR NUEVA CUENTA_NOMINA
	 * @param cuentaCheques
	 * @return true - SI SE AGREGO CORRECTAMENTE LA CUENTA_NOMINA, CASO CONTRARIO return false.
	 */
	public boolean agregarCuentaNomina(CuentaNomina cuentaNomina) {
		if(buscarCuentaNomina(cuentaNomina.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			_listaCuentaNomina.add(cuentaNomina);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * M�TODO PARA ELIMINAR CUENTA_NOMINA POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return false - SI NO SE ENCONTRO LA CUENTA_NOMINA, CASO CONTRARIO return true.
	 */
	public boolean eliminarCuentaNomina(CuentaNomina cuentaNomina) {
		if(buscarCuentaNomina(cuentaNomina.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			_listaCuentaNomina.remove(cuentaNomina);//ELIMINA CUENTA_AHORRO ENCONTRADO
			return true;
		}
	}
	
	/**
	 * M�TODO PARA MODIFICAR CUENTA_NOMINA EN LA COLECCI�N
	 * @param CuentaNominaModificado
	 * @param posicion
	 * @return false - SI NO LO ENCUENTRA EN LA COLECCION, CASO CONTRARIO return true (CUENTA_NOMINA MODIFICADO)
	 */
	public boolean ModificarCuentaAhorro(CuentaNomina CuentaNominaModificado, int posicion) {
		
		if(posicion<0 || posicion>_listaCuentaNomina.size()) {
			return false;
		}else {
			CuentaNomina CuentaBuscada = buscarCuentaNomina(CuentaNominaModificado.get_numeroCuenta());
			if(CuentaBuscada != null) {
				_listaCuentaNomina.set(posicion, CuentaNominaModificado);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N CUENTA_NOMINA
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public CuentaNomina getPosicion(int posicion) {
		return _listaCuentaNomina.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<_listaCuentaNomina.size();i++) {
			System.out.println(_listaCuentaNomina.get(i));
		}
	}

}
