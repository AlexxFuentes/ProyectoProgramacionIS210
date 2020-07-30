package gestionClases;

import java.util.LinkedList;

import clases.TarjetaCreditoPropias;

/**
 * CLASE: TARJETASCREDITOPROPIAS
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionTarjetasCretitoPropias {
	//ATRIBUTO GESTION TARJETAS CREDITPO PROPIAS
	private LinkedList<TarjetaCreditoPropias> listaTCP=new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionTarjetasCretitoPropias() {
		super();
	}
	
    //CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionTarjetasCretitoPropias(LinkedList<TarjetaCreditoPropias> listaTCP) {
		super();
		this.listaTCP = listaTCP;
	}


	/**
     * METODO PARA BUSCAR TCP
     * @param tcp
     * return tcp
     */
	
	public TarjetaCreditoPropias BuscarTarjetaTCP(TarjetaCreditoPropias tcp) {
		tcp = null;
		
		for(int i = 0; i < listaTCP.size(); i++) {
			if( listaTCP.get(i).equals(tcp)) {
				tcp = listaTCP.get(i);
			}
		}
		return tcp;
	}
	
	/**
	 * M�TODO QUE AGREGAR TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCP
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarTarjetaTCP(TarjetaCreditoPropias tarjetaTCP) {
		
		if(BuscarTarjetaTCP(tarjetaTCP) == null) {//Si la tarjeta no esta agregada
			
			listaTCP.add(tarjetaTCP);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * M�TODO QUE MODIFICA LA TARJETA DE CREDITO PROPIAS
	 * @param tarjetaTCPModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarTarjetaTCP(TarjetaCreditoPropias tarjetaTCPModificar, int posicion) {
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
	
	public boolean EliminarTarjetaTCP(TarjetaCreditoPropias tarjetaTCPEliminar) {
		
		if(BuscarTarjetaTCP(tarjetaTCPEliminar) == null) {
			return false;
		}else {
			listaTCP.remove(BuscarTarjetaTCP(tarjetaTCPEliminar));
			return true;
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N TARJETA CREDITO PROPIAS
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public TarjetaCreditoPropias getPosicion(int posicion) {
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
