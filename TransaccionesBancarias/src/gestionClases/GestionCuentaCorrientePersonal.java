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
	private LinkedList<CuentaCorrientePersonal> listaCuentaCorrientePersonal = new LinkedList<>();

	//CONSTRUCTOR POR DEFECTO
	public GestionCuentaCorrientePersonal() {
		super();
	}

	//CONSTRUCTOR CON TODOS LOS CAMPOS
	public GestionCuentaCorrientePersonal(LinkedList<CuentaCorrientePersonal> listaCuentaCorrientePersonal) {
		super();
		this.listaCuentaCorrientePersonal = listaCuentaCorrientePersonal;
	}

	/**
	 * M�TODO QUE OBTIENE UN CUENTA_CORRIENTE_PERSONAL DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<CuentaCorrientePersonal> getCuentaCorrientePersonal(){
		return listaCuentaCorrientePersonal;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA_CORRIENTE_PERSONAL POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA_CORRIENTE_PERSONAL, CASO CONTRARIO RETORNA OBJ.CUENTA_CORRIENTE_PERSONAL
	 */
	public CuentaCorrientePersonal BuscarCuentaCorrientePersonal(String numCuenta) {
		CuentaCorrientePersonal CuentaCorrientePersonalBuscada = null;
		for(int i = 0; i < listaCuentaCorrientePersonal.size(); i++) {
			if( listaCuentaCorrientePersonal.get(i).get_numeroCuenta().equals(numCuenta)) {
				CuentaCorrientePersonalBuscada = listaCuentaCorrientePersonal.get(i);
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
		if(BuscarCuentaCorrientePersonal(cuentaCorrientePersonal.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			listaCuentaCorrientePersonal.add(cuentaCorrientePersonal);
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
		if(BuscarCuentaCorrientePersonal(CuentaCorriPersonal.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			listaCuentaCorrientePersonal.remove(CuentaCorriPersonal);//ELIMINA CUENTA_AHORRO ENCONTRADO
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
		
		if(posicion<0 || posicion>listaCuentaCorrientePersonal.size()) {
			return false;
		}else {
			
			if(BuscarCuentaCorrientePersonal(CuentaCorrientePerModificado.get_numeroCuenta()) != null) {
				listaCuentaCorrientePersonal.set(posicion, CuentaCorrientePerModificado);
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
		return listaCuentaCorrientePersonal.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaCuentaCorrientePersonal.size();i++) {
			System.out.println(listaCuentaCorrientePersonal.get(i));
		}
	}
}
