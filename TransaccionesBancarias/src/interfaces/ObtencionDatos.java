package interfaces;

import utileria.AdminFechas;
import clases.CuentaBancaria;

public interface ObtencionDatos {
	
	public String _fecha = AdminFechas.getFechaActualString();
	
	double getdepositos(CuentaBancaria tipocuenta);
	double getRetiro(CuentaBancaria tipocuenta);
	public int getNumeroCuenta();

}
