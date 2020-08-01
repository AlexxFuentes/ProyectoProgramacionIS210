package gestionClases;

import java.util.LinkedList;

import clases.Beneficiario;

/**
 * CLASE GESTIÓN DE USUARIO: DONDE SE ADMINISTRAN LOS DATOS DEL USUARIO: TITULAR
 * @author alex Fuentes
 * 
 *FECHA: 01/08/2020
 */

public class GestionBeneficiario {

	private LinkedList<Beneficiario> _listaBeneficiario = new LinkedList<>();
	
	public LinkedList<Beneficiario> getBeneficiario(){
		return _listaBeneficiario;
	}
	
	
	public Beneficiario buscarBeneficiario(String RTN) {
		Beneficiario beneficiarioBuscado = null;
		for(int i = 0; i < _listaBeneficiario.size(); i++) {
			if(_listaBeneficiario.get(i).get_rtn().equals(RTN)) {
				beneficiarioBuscado = _listaBeneficiario.get(i);
				break;
			}
		}
		return beneficiarioBuscado;
	}
	
	public int buscarBeneficiarioPorPosicion(String RTN) {
		int posicion = -1;
		for(int i = 0; i < _listaBeneficiario.size();) {
			if( _listaBeneficiario.get(i).get_rtn().equals(RTN) ) {
				posicion = i;
				break;
			}
		}
		
		return posicion;
	}
	
	public boolean agregarBeneficiario(Beneficiario beneficiarioAgregar) {
		if(buscarBeneficiario(beneficiarioAgregar.get_rtn()) == null) {
			_listaBeneficiario.add(beneficiarioAgregar);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean eliminarBeneficiario(Beneficiario beneficiario) {
		if(buscarBeneficiario(beneficiario.get_rtn()) == null) {
			return false;
		}else {
			_listaBeneficiario.remove(beneficiario);
			return true;
		}
	}
	
	public boolean ModificarUsuario(Beneficiario BeneficiarioModificado, int posicion) {
		if(posicion<0 || posicion>_listaBeneficiario.size()) {
			return false;
		}else {
			if(buscarBeneficiario(BeneficiarioModificado.get_rtn()) != null) {
				_listaBeneficiario.set(posicion, BeneficiarioModificado);
				return true;
			}else {
				return false;
			}
		}
	}
	
}
