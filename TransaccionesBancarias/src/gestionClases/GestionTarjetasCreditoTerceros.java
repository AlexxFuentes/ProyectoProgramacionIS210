package gestionClases;

import java.util.LinkedList;

import clases.TarjetaCreditoTerceros;

/**
 * CLASE: TARJETASCREDITOTERCEROS
 * @author GLENY NIHIMAYA
 * DESCRIPCION: GESTIONES Y METODOS CORRESPONDIENTE A DICHA CLASE.
 * FECHA: 18/07/2020
 */

public class GestionTarjetasCreditoTerceros {
	//ATRIBUTO GESTION TARJETA CREDITO A TERCEROS
	private LinkedList<TarjetaCreditoTerceros> listaTCT=new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionTarjetasCreditoTerceros() {
		super();
	}
	
    //CONSTRUCTOR CON SUS ATRIBUTOS
	public GestionTarjetasCreditoTerceros(LinkedList<TarjetaCreditoTerceros> listaTCT) {
		super();
		this.listaTCT = listaTCT;
	}

    //GETTERS Y SETTERS
	public LinkedList<TarjetaCreditoTerceros> getListaTCT() {
		return listaTCT;
	}

	public void setListaTCT(LinkedList<TarjetaCreditoTerceros> listaTCT) {
		this.listaTCT = listaTCT;
	}

	/**
     * METODO PARA BUSCAR TCT
     * @param tct
     * return tct
     */
	
	public TarjetaCreditoTerceros BuscarTarjetaTCT(TarjetaCreditoTerceros tct) {
		tct = null;
		
		for(int i = 0; i < listaTCT.size(); i++) {
			if( listaTCT.get(i).equals(tct)) {
				tct = listaTCT.get(i);
			}
		}
		return tct;
	}
	
	/**
	 * MÉTODO QUE AGREGAR TARJETA DE CREDITO A TERCEROS
	 * @param tarjetaTCT
	 * @return true - SI SE AGREGA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarTarjetaTCT(TarjetaCreditoTerceros tarjetaTCT) {
		
		if(BuscarTarjetaTCT(tarjetaTCT) == null) {//Si la tarjeta no esta agregada
			
			listaTCT.add(tarjetaTCT);
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * MÉTODO QUE MODIFICA LA TARJETA DE CREDITO A TERCEROS
	 * @param tarjetaTCTModificar
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarTarjetaTCT(TarjetaCreditoTerceros tarjetaTCTModificar, int posicion) {
		if(posicion<0 || posicion>listaTCT.size()) {
			return false;
		}else {
	
			if(BuscarTarjetaTCT(tarjetaTCTModificar) != null) {
				listaTCT.set(posicion, tarjetaTCTModificar);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR LA TARJETA DE CREDITO A TERCEROS
	 * @param tarjetaTCTEliminar
	 * @return true - SI TODOS SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarPago(TarjetaCreditoTerceros tarjetaTCTEliminar) {
		
		if(BuscarTarjetaTCT(tarjetaTCTEliminar) == null) {
			return false;
		}else {
			listaTCT.remove(BuscarTarjetaTCT(tarjetaTCTEliminar));
			return true;
		}
	}
	
	/**
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN TARJETA CREDITO TERCEROS
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public TarjetaCreditoTerceros getPosicion(int posicion) {
		return listaTCT.get(posicion);
	}
	
	/**
	 * METODO PARA IMPRIMIR TODOS
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaTCT.size();i++) {
			System.out.println(listaTCT.get(i));
		}
	}
	
}
