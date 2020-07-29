package gestionClases;

import java.util.LinkedList;

import clases.CuentaCorrientePersonal;

/**
 * GESTIÓN CUENTA CORRIENTE PERSONAL: OPERACIONES QUE SE REALIZAN
 * @author Alex Fuentes
 *
 *FECHA: 18/07/2020
 */

public class GestionCuentaCorrientePersonal {
	
	//ATRIBUTOS (COLECCIÓN)
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
	 * MÉTODO QUE OBTIENE UN CUENTA_CORRIENTE_PERSONAL DE LA COLECCIÓN
	 * @return ELEMETO COLECCIÓN
	 */
	public LinkedList<CuentaCorrientePersonal> getCuentaCorrientePersonal(){
		return listaCuentaCorrientePersonal;
	}
	
	/**
	 * MÉTODO PARA BUSCAR CUENTA_CORRIENTE_PERSONAL POR NÚMERO DE CUENTA
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
	 * MÉTODO PARA AGREFAR NUEVA CUENTA_CORRIENTE_PERSONAL
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
	 * MÉTODO PARA ELIMINAR CUENTA_CORRIENTE_PERSONAL POR NÚMERO DE CUENTA
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
	 * MÉTODO PARA MODIFICAR CUENTA_CORRIENTE_PERSONAL EN LA COLECCIÓN
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
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN CUENTA_AHORRO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public CuentaCorrientePersonal getPosicion(int posicion) {
		return listaCuentaCorrientePersonal.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaCuentaCorrientePersonal.size();i++) {
			System.out.println(listaCuentaCorrientePersonal.get(i));
		}
	}
}
