package gestionClases;

import java.util.LinkedList;

import clases.Usuario;

/**
 * CLASE GESTI�N DE USUARIO: DONDE SE ADMINISTRAN LOS DATOS DEL USUARIO: TITULAR
 * @author alex Fuentes
 * 
 *FECHA: 16/07/2020
 */

public class GestionUsuario {
	
	//ATRIBUTOS (COLECCI�N)
	private LinkedList<Usuario> listaUsuario = new LinkedList<>();
	
	//CONSTRUCTOR POR DEFECTO
	public GestionUsuario() {
		super();
	}
	
	//CONSTRUCTOR DE LA CLASE CON TODOS LOS CAMPOS
	public GestionUsuario(LinkedList<Usuario> listaUsuario) {
		super();
		this.listaUsuario = listaUsuario;
	}

	/**
	 * M�TODO QUE OBTIENE UN USUARIO DE LA COLECCI�N
	 * @return ELEMETO COLECCI�N
	 */
	public LinkedList<Usuario> getUsuario(){
		return listaUsuario;
	}
	
	/**
	 * M�TODO QUE BUSCA USUARIO POR RTN
	 * @param RTN
	 * @return -1 - SI NO ENCONTRO EL USUARIO, CASO CONTRARIO return LA POSICI�N
	 */
	public int buscarUsuarioPosicion(String RTN) {
		int posicion = -1;
		for(int i = 0; i < listaUsuario.size();) {
			if( listaUsuario.get(i).get_rtn().equals(RTN) ) {
				posicion = i;
				break;
			}
		}
		return posicion;
	}
	/**
	 * M�TODO PARA BUSCAR USUARIO POR RTN
	 * @param RTN
	 * @return OBJUSUARIO
	 */
	public Usuario buscarUsuario(String RTN) {
		Usuario usuarioBuscado = null;
		for(int i = 0; i < listaUsuario.size(); i++) {
			if(listaUsuario.get(i).get_rtn().equals(RTN)) {
				usuarioBuscado = listaUsuario.get(i);
				break;
			}
		}
		return usuarioBuscado;
	}
	
	/**
	 * M�TODO PARA AGREGAR USUARIO
	 * @param usuario
	 * @return true - SI SE AGREGO CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean AgregarUsuario(Usuario usuario) {
		if(buscarUsuarioPosicion(usuario.get_rtn()) == -1) {
			listaUsuario.add(usuario);
			return true;
		}else {
			return false;
		}
	}
	/**
	 * M�TODO PARA ELIMINAR USUARIO DE LA COLECCI�N
	 * @param usuario
	 * @return true - SI SE ELIMINO CORRECTAMENTE, CASO CONTRARIO return false
	 */
	public boolean eliminarUsuario(Usuario usuario) {
		if(buscarUsuarioPosicion(usuario.get_rtn()) == -1) {
			return false;
		}else {
			listaUsuario.remove(usuario);
			return true;
		}
	}
	/**
	 * M�TODO PARA ELIMINAR USUARIO
	 * @param usuarioModificado
	 * @param posicion
	 * @return true -  SI SE MODIFICO CORRECTAMENTE, CASO CONTRARIO return false.
	 */
	public boolean ModificarUsuario(Usuario usuarioModificado, int posicion) {
		if(posicion<0 || posicion>listaUsuario.size()) {
			return false;
		}else {
			if(buscarUsuarioPosicion(usuarioModificado.get_rtn()) != 1) {
				listaUsuario.set(posicion, usuarioModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * M�TODO PARA OBTENER POSICI�N DE LA COLECCI�N USUARIO
	 * @param posicion
	 * @return POSICI�N O INDICE DE LA COLECI�N
	 */
	public Usuario getUsuarioPorPosicion(int posicion) {
		return listaUsuario.get(posicion);
	}
	
	/**
	 * M�TODO PARA IMPRIMIR TODA LA COLECCI�N
	 */
	public void imprimirTodos() {
		for(int i=0;i<listaUsuario.size();i++) {
			System.out.println(listaUsuario.get(i));
		}
	}
	
	public boolean confirmar(String dato1, String dato2) {
		if(dato1.equals(dato2)) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getCodigoUsuario() {
		String _numUsuario = "USUARIO_" + listaUsuario.size()+1;
		
		return _numUsuario;
	}
	
	
	public boolean buscarNombreUsuario(String usuario) {
		for(int i = 0; i < listaUsuario.size();) {
			if(listaUsuario.get(i).get_nombreUsuario().equals(usuario)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	public boolean buscarcontrasena(String contrasena) {
		for(int i = 0; i < listaUsuario.size();) {
			if(listaUsuario.get(i).get_contrasena().equals(contrasena)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
