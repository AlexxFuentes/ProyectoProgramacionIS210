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
	private LinkedList<CuentaAhorro> listaCuentaAhorro = new LinkedList<>();

	//CONSTRUCTOR POR DEFECTO
	public GestionCuentaAhorro() {
		super();
	}

	//CONSTRUCTOR CON TODOS LOS CAMPOS
	public GestionCuentaAhorro(LinkedList<CuentaAhorro> listaCuentaAhorro) {
		super();
		this.listaCuentaAhorro = listaCuentaAhorro;
	}
	
	/**
	 * M�TODO QUE OBTIENE UN CUENTA AHORRO DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<CuentaAhorro> getCuentaAhorro(){
		return listaCuentaAhorro;
	}
	
	/**
	 * M�TODO PARA BUSCAR CUENTA DE AHORRO POR N�MERO DE CUENTA
	 * @param numCuenta
	 * @return null - SI NO ENCUENTRA LA CUENTA AHORRO, CASO CONTRARIO RETORNA OBJ.CUENTAAHORRO
	 */
	public CuentaAhorro BuscarCuentaAhorro(String numCuenta) {
		CuentaAhorro CuentaAhorroBuscada = null;
		for(int i = 0; i < listaCuentaAhorro.size(); i++) {
			if( listaCuentaAhorro.get(i).get_numeroCuenta().equals(numCuenta)) {
				CuentaAhorroBuscada = listaCuentaAhorro.get(i);
			}
		}
		return CuentaAhorroBuscada;
	}
	
	/**
	 * M�TODO PARA AGREFAR NUEVA CUENTA DE AHORRO
	 * @param cuentaAhorro
	 * @return true - SI SE AGREGO CORRECTAMENTE LA CUENTA_AHORRO, CASO CONTRARIO return false.
	 */
	public boolean AgregarCuentaAhorro(CuentaAhorro cuentaAhorro) {
		if(BuscarCuentaAhorro(cuentaAhorro.get_numeroCuenta()) == null) {//Si el usuario no esta agregado
			listaCuentaAhorro.add(cuentaAhorro);
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
	public boolean EliminarCuentaAhorro(CuentaAhorro CuentaAhorro) {
		if(BuscarCuentaAhorro(CuentaAhorro.get_numeroCuenta()) == null) {//CUENTA_AHORRO NO ENCONTRADO
			return false;
		}else {
			listaCuentaAhorro.remove(CuentaAhorro);//ELIMINA CUENTA_AHORRO ENCONTRADO
			return true;
		}
	}
	
	/**
	 * M�TODO PARA MODIFICAR CUENTA_AHORRO EN LA COLECCI�N
	 * @param CuentaAhorroModificado
	 * @param posicion
	 * @return false - SI NO LO ENCUENTRA EN LA COLECCION, CASO CONTRARIO return true (CUENTA_AHORRO MODIFICADO)
	 */
	public boolean ModificarCuentaAhorro(CuentaAhorro CuentaAhorroModificado, int posicion) {
		
		if(posicion<0 || posicion>listaCuentaAhorro.size()) {
			return false;
		}else {
			
			if(BuscarCuentaAhorro(CuentaAhorroModificado.get_numeroCuenta()) != null) {
				listaCuentaAhorro.set(posicion, CuentaAhorroModificado);
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
		return listaCuentaAhorro.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaCuentaAhorro.size();i++) {
			System.out.println(listaCuentaAhorro.get(i));
		}
	}
	
	/**
	 * M�TODO QUE CALCULA EL INTERES REMUNERADO DE UNA CUENTA DE AHORRO
	 * @param MontoInicial
	 * @return Interesesremunerados
	 */
	public double InteresRemunerado(double MontoInicial) {
		double Interesesremunerados = 0;
		
		if(MontoInicial >= 0 || MontoInicial <= 999.99 ) {
			Interesesremunerados = (MontoInicial*(0.0005)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 1000 || MontoInicial <= 9999.99 ) {
			Interesesremunerados =  (MontoInicial*(0.0075)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 10000 || MontoInicial <= 24999.99 ) {
			Interesesremunerados =  (MontoInicial*(0.01)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 25000 || MontoInicial <= 49999.99 ) {
			Interesesremunerados = (MontoInicial*(0.0126)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 50000 || MontoInicial <= 99999.99 ) {
			Interesesremunerados = MontoInicial + (MontoInicial*(0.0151)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 100000 || MontoInicial <= 249999.99 ) {
			Interesesremunerados = (MontoInicial*(0.0176)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 250000 || MontoInicial <= 499999.99 ) {
			Interesesremunerados = (MontoInicial*(0.0176)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 500000 || MontoInicial <= 999999.99 ) {
			Interesesremunerados = (MontoInicial*(0.0176)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 1000000 || MontoInicial <= 1999999.99 ) {
			Interesesremunerados = (MontoInicial*(0.0176)); 
			return Interesesremunerados;
		} else if(MontoInicial >= 2000000 || MontoInicial > 2000000 ) {
			Interesesremunerados =   (MontoInicial*(0.0176)); 
			return Interesesremunerados;
		}else {
			return Interesesremunerados;
		}
	}
}
