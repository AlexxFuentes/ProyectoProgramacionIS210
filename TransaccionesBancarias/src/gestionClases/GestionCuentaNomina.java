package gestionClases;

import java.util.LinkedList;
import clases.CuentaNomina;

/**
 * GESTIÓN DE CUENTA_NOMINA: OPERACIONES QUE SE PUEDEN REALIZAR
 * @author Alex Fuentes
 *
 *FECHA: 18/07/2020
 */
public class GestionCuentaNomina {
	
	//ATRIBUTOS (COLECCIÓN)
	private LinkedList<CuentaNomina> listaCuentaNomina = new LinkedList<>();

	//CONSTRUCTOR POR DEFECTO 
	public GestionCuentaNomina() {
		super();
	}

	//CONSTRUCTOR CON TODOS LOS CAMPOS
	public GestionCuentaNomina(LinkedList<CuentaNomina> listaCuentaNomina) {
		super();
		this.listaCuentaNomina = listaCuentaNomina;
	}
	
	/**
	 * MÉTODO QUE OBTIENE UNA CUENTA_NOMINA DE LA COLECCIÓN
	 * @return ELEMETO COLECCIÓN
	 */
	public LinkedList<CuentaNomina> getCuentaCheques(){
		return listaCuentaNomina;
	}
	
	/**
	 * MÉTODO PARA BUSCAR CUENTA_NOMINA POR NÚMERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA_NOMINA, CASO CONTRARIO RETORNA OBJ.CUENTA_NOMINA
	 */
	public CuentaNomina BuscarCuentaNomina(String numCuenta) {
		CuentaNomina CuentaNominaBuscada = null;
		for(int i = 0; i < listaCuentaNomina.size(); i++) {
			if( listaCuentaNomina.get(i).get_numeroCuenta().equals(numCuenta)) {
				CuentaNominaBuscada = listaCuentaNomina.get(i);
			}
		}
		return CuentaNominaBuscada;
	}
	
	/**
	 * MÉTODO PARA AGREFAR NUEVA CUENTA_NOMINA
	 * @param cuentaCheques
	 * @return true - SI SE AGREGO CORRECTAMENTE LA CUENTA_NOMINA, CASO CONTRARIO return false.
	 */
	public boolean AgregarCuentaNomina(CuentaNomina cuentaNomina) {
		if(BuscarCuentaNomina(cuentaNomina.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			listaCuentaNomina.add(cuentaNomina);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO PARA ELIMINAR CUENTA_NOMINA POR NÚMERO DE CUENTA
	 * @param numCuenta
	 * @return false - SI NO SE ENCONTRO LA CUENTA_NOMINA, CASO CONTRARIO return true.
	 */
	public boolean EliminarCuentaNomina(CuentaNomina cuentaNomina) {
		if(BuscarCuentaNomina(cuentaNomina.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			listaCuentaNomina.remove(cuentaNomina);//ELIMINA CUENTA_AHORRO ENCONTRADO
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA MODIFICAR CUENTA_NOMINA EN LA COLECCIÓN
	 * @param CuentaNominaModificado
	 * @param posicion
	 * @return false - SI NO LO ENCUENTRA EN LA COLECCION, CASO CONTRARIO return true (CUENTA_NOMINA MODIFICADO)
	 */
	public boolean ModificarCuentaAhorro(CuentaNomina CuentaNominaModificado, int posicion) {
		
		if(posicion<0 || posicion>listaCuentaNomina.size()) {
			return false;
		}else {
			CuentaNomina CuentaBuscada = BuscarCuentaNomina(CuentaNominaModificado.get_numeroCuenta());
			if(CuentaBuscada != null) {
				listaCuentaNomina.set(posicion, CuentaNominaModificado);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN CUENTA_NOMINA
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public CuentaNomina getPosicion(int posicion) {
		return listaCuentaNomina.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaCuentaNomina.size();i++) {
			System.out.println(listaCuentaNomina.get(i));
		}
	}

}
