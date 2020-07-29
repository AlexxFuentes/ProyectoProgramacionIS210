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
	 * M�TODO QUE OBTIENE UNA CUENTA_NOMINA DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<CuentaNomina> getCuentaCheques(){
		return listaCuentaNomina;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA_NOMINA POR N�MERO DE CUENTA
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
	 * M�TODO PARA AGREFAR NUEVA CUENTA_NOMINA
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
	 * M�TODO PARA ELIMINAR CUENTA_NOMINA POR N�MERO DE CUENTA
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
	 * M�TODO PARA MODIFICAR CUENTA_NOMINA EN LA COLECCI�N
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
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N CUENTA_NOMINA
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public CuentaNomina getPosicion(int posicion) {
		return listaCuentaNomina.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaCuentaNomina.size();i++) {
			System.out.println(listaCuentaNomina.get(i));
		}
	}

}
