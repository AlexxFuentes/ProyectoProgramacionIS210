package gestionClases;

import java.util.LinkedList;

import clases.Usuario;

/**
 * CLASE GESTIÓN DE USUARIO: DONDE SE ADMINISTRAN LOS DATOS DEL USUARIO: TITULAR
 * @author alex Fuentes
 * 
 *FECHA: 16/07/2020
 */

public class GestionUsuario {
	
	//ATRIBUTOS (COLECCIÓN)
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
	 * MÉTODO QUE OBTIENE UN USUARIO DE LA COLECCIÓN
	 * @return ELEMETO COLECCIÓN
	 */
	public LinkedList<Usuario> getUsuario(){
		return listaUsuario;
	}
	
	/**
	 * MÉTODO QUE BUSCA USUARIO POR RTN
	 * @param RTN
	 * @return -1 - SI NO ENCONTRO EL USUARIO, CASO CONTRARIO return LA POSICIÓN
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
	 * MÉTODO PARA BUSCAR USUARIO POR RTN
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
	 * MÉTODO PARA AGREGAR USUARIO
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
	 * MÉTODO PARA ELIMINAR USUARIO DE LA COLECCIÓN
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
	 * MÉTODO PARA ELIMINAR USUARIO
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
	 * MÉTODO PARA OBTENER POSICIÓN DE LA COLECCIÓN USUARIO
	 * @param posicion
	 * @return POSICIÓN O INDICE DE LA COLECIÓN
	 */
	public Usuario getUsuarioPorPosicion(int posicion) {
		return listaUsuario.get(posicion);
	}
	
	/**
	 * MÉTODO PARA IMPRIMIR TODA LA COLECCIÓN
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
