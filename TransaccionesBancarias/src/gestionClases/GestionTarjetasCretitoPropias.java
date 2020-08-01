package gestionClases;

import java.util.LinkedList;

import clases.TarjetaCredito;

/**
 * CLASE: TARJETASCREDITOPROPIAS
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionTarjetasCretitoPropias {
	//ATRIBUTO GESTION TARJETAS CREDITPO PROPIAS
	private LinkedList<TarjetaCredito> listaTCP=new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionTarjetasCretitoPropias() {
		super();
	}
	
    //CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionTarjetasCretitoPropias(LinkedList<TarjetaCredito> listaTCP) {
		super();
		this.listaTCP = listaTCP;
	}


	/**
     * METODO PARA BUSCAR TCP
     * @param tcp
     * return tcp
     */
	
	public TarjetaCredito BuscarTarjetaTCP(TarjetaCredito tcp) {
		tcp = null;
		
		for(int i = 0; i < listaTCP.size(); i++) {
			if( listaTCP.get(i).equals(tcp)) {
				tcp = listaTCP.get(i);
			}
		}
		return tcp;
	}
	
	/**
	 * MÉTODO QUE AGREGAR TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCP
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarTarjetaTCP(TarjetaCredito tarjetaTCP) {
		
		if(BuscarTarjetaTCP(tarjetaTCP) == null) {//Si la tarjeta no esta agregada
			
			listaTCP.add(tarjetaTCP);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA LA TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCPModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarTarjetaTCP(TarjetaCredito tarjetaTCPModificar, int posicion) {
		if(posicion<0 || posicion>listaTCP.size()) {
			return false;
		}else {
	
			if(BuscarTarjetaTCP(tarjetaTCPModificar) != null) {
				listaTCP.set(posicion, tarjetaTCPModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR LA TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCPEliminar
	 * @return true - SI TODOS SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarTarjetaTCP(TarjetaCredito tarjetaTCPEliminar) {
		
		if(BuscarTarjetaTCP(tarjetaTCPEliminar) == null) {
			return false;
		}else {
			listaTCP.remove(BuscarTarjetaTCP(tarjetaTCPEliminar));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN TARJETA CREDITO PROPIAS
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public TarjetaCredito getPosicion(int posicion) {
		return listaTCP.get(posicion);
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaTCP.size();i++) {
			System.out.println(listaTCP.get(i));
		}
	}
}
