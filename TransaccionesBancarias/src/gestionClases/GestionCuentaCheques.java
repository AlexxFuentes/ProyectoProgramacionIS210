package gestionClases;

import java.util.LinkedList;
import clases.CuentaCheques;

/**
 * GESTIÓN CUENTA DE CHEQUES: OPERACIONES QUE SE REALIZAN
 * @author Alex Fuentes
 * 
 *FECHA: 18/07/2020
 */

public class GestionCuentaCheques {

	//ATRIBUTOS (COLECCIÓN)
	private LinkedList<CuentaCheques> listaCuentaCheques = new LinkedList<>();

	//CONSTRUCTOR POR DEFECTO
	public GestionCuentaCheques() {
		super();
	}

	//CONSTRUCTOR CON TODOS LOS CAMPOS
	public GestionCuentaCheques(LinkedList<CuentaCheques> listaCuentaCheques) {
		super();
		this.listaCuentaCheques = listaCuentaCheques;
	}
	
	/**
	 * MÉTODO QUE OBTIENE UN CUENTA CHEQUES DE LA COLECCIÓN
	 * @return ELEMETO COLECCIÓN
	 */
	public LinkedList<CuentaCheques> getCuentaCheques(){
		return listaCuentaCheques;
	}
	
	/**
	 * MÉTODO PARA BUSCAR CUENTA_CHEQUES POR NÚMERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA_CHEQUES, CASO CONTRARIO RETORNA OBJ.CUENTA_CHEQUES
	 */
	public CuentaCheques BuscarCuentaCheques(int numCuenta) {
		CuentaCheques CuentaChequesBuscada = null;
		for(int i = 0; i < listaCuentaCheques.size(); i++) {
			if( listaCuentaCheques.get(i).get_numeroCuenta() == numCuenta) {
				CuentaChequesBuscada = listaCuentaCheques.get(i);
			}
		}
		return CuentaChequesBuscada;
	}
	
	/**
	 * MÉTODO PARA AGREFAR NUEVA CUENTA_CHEQUES
	 * @param cuentaCheques
	 * @return true - SI SE AGREGO CORRECTAMENTE LA CUENTA_CHEQUES, CASO CONTRARIO return false.
	 */
	public boolean AgregarCuentaCheques(CuentaCheques cuentaCheques) {
		if(BuscarCuentaCheques(cuentaCheques.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			listaCuentaCheques.add(cuentaCheques);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO PARA ELIMINAR CUENTA_CHEQUES POR NÚMERO DE CUENTA
	 * @param numCuenta
	 * @return false - SI NO SE ENCONTRO LA CUENTA_CHEQUES, CASO CONTRARIO return true.
	 */
	public boolean EliminarCuentaCheques(clases.CuentaCheques CuentaCheques) {
		if(BuscarCuentaCheques(CuentaCheques.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			listaCuentaCheques.remove(CuentaCheques);//ELIMINA CUENTA_AHORRO ENCONTRADO
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA MODIFICAR CUENTA_CHEQUES EN LA COLECCIÓN
	 * @param CuentaChequeModificado
	 * @param posicion
	 * @return false - SI NO LO ENCUENTRA EN LA COLECCION, CASO CONTRARIO return true (CUENTA_CHEQUES MODIFICADO)
	 */
	public boolean ModificarCuentaAhorro(CuentaCheques CuentaChequeModificado, int posicion) {
		
		if(posicion<0 || posicion>listaCuentaCheques.size()) {
			return false;
		}else {
			
			if(BuscarCuentaCheques(CuentaChequeModificado.get_numeroCuenta()) != null) {
				listaCuentaCheques.set(posicion, CuentaChequeModificado);
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
	public CuentaCheques getPosicion(int posicion) {
		return listaCuentaCheques.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaCuentaCheques.size();i++) {
			System.out.println(listaCuentaCheques.get(i));
		}
	}
	
	public double interesRemunerados(double Monto) {
		double Interesesremunerados = 0;
		
		if(Monto >= 0 || Monto <= 500000 ) {
			Interesesremunerados = (Monto*(0.0)); 
			return Interesesremunerados;
		} else if(Monto >= 500000 || Monto <= 1000000 ) {
			Interesesremunerados =  (Monto*(0.0025)); 
			return Interesesremunerados;
		} else if(Monto >= 1000000 || Monto <= 2000000 ) {
			Interesesremunerados =  (Monto*(0.005)); 
			return Interesesremunerados;
		} else if(Monto >= 2000000 || Monto > 2000000 ) {
			Interesesremunerados = (Monto*(0.0356)); 
			return Interesesremunerados;
		} else {
			return Interesesremunerados;
		}
	}
	
}
