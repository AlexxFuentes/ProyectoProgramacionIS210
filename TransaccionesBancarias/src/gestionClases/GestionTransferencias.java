package gestionClases;

/*
 * AUTORA: GLENY NIHIMAYA

 * CLASE: GESTION TRANSFERENCIAS
 * DESCRIPCION: PERMITE QUE EL USUARIO ELIJA EL TIPO
 *              DE TRANSFERENCIA QUE REALIZARA.
 * FECHA: 18/07/2020
 */
import java.util.LinkedList;


import clases.Transferencias;


public class GestionTransferencias {
      private LinkedList<Transferencias> listaTransferencias = new LinkedList<>();

	public GestionTransferencias() {
		super();
	}

	public LinkedList<Transferencias> getListaTransferencias() {
		return listaTransferencias;
	}

	public void setListaTransferencias(LinkedList<Transferencias> listaTransferencias) {
		this.listaTransferencias = listaTransferencias;
	}
      
      /**
       * METODO PARA BUSCAR UNA TRANSFERENCIA
       * @param 
       * 
       */
	
	public Transferencias BuscarTransferencias(Transferencias transferencia) {
		transferencia = null; 
		for(int i=0; i<listaTransferencias.size();++i) {
			if(listaTransferencias.get(i).equals(transferencia)) {
				transferencia = listaTransferencias.get(i);
			}
		}
		return transferencia;
	}

	/**
	 * METODO PARA AGREGAR TRANSFERENCIA
	 * @param agregarTransferencia
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false.
	 */
	
	public boolean AgregarTransferencia(Transferencias agregarTransferencia) {
		if(BuscarTransferencias(agregarTransferencia) == null) {
			listaTransferencias.add(agregarTransferencia);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * M�TODO QUE MODIFICA LA TRANSFERENCIA
	 * @param TransferenciaModificada
	 * @param posicion
	 * @return true - SI SE MODIFICA CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean ModificarTransferencia(Transferencias TransferenciaModificada, int posicion) {
		if(posicion<0 || posicion>listaTransferencias.size()) {
			return false;
		}else {
	
			if(BuscarTransferencias(TransferenciaModificada) != null) {
				listaTransferencias.set(posicion, TransferenciaModificada);
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	/**
	 * METODO UTILIZADO PARA ELIMINAR LA TRANSFERENCIA
	 * @param MONTO 
	 * @return true - SI TODO SE REALIZO CORRECTAMENTE , CASO CONTRARIO RETORNA FALSE
	 */
	
	public boolean EliminarTransferencia(Transferencias transEliminada) {
		
		if(transEliminada == null) {
			return false;
		}else {
			listaTransferencias.remove(transEliminada);
			return true;
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N TIPO DE CUENTA
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public Transferencias getPosicion(int posicion) {
		return listaTransferencias.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i = 0 ; i < listaTransferencias.size(); i++) {
			System.out.println(listaTransferencias.get(i));
		}
	} 
	
}
