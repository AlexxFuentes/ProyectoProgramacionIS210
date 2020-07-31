package gestionClases;

import java.util.LinkedList;
import clases.CuentaCheques;

/**
 * GESTI�N CUENTA DE CHEQUES: OPERACIONES QUE SE REALIZAN
 * @author Alex Fuentes
 * 
 *FECHA: 18/07/2020
 */

public class GestionCuentaCheques {

	//ATRIBUTOS (COLECCI�N)
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
	 * M�TODO QUE OBTIENE UN CUENTA CHEQUES DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<CuentaCheques> getCuentaCheques(){
		return listaCuentaCheques;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA_CHEQUES POR N�MERO DE CUENTA
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
	 * M�TODO PARA AGREFAR NUEVA CUENTA_CHEQUES
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
	 * M�TODO PARA ELIMINAR CUENTA_CHEQUES POR N�MERO DE CUENTA
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
	 * M�TODO PARA MODIFICAR CUENTA_CHEQUES EN LA COLECCI�N
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
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N CUENTA_AHORRO
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public CuentaCheques getPosicion(int posicion) {
		return listaCuentaCheques.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
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
