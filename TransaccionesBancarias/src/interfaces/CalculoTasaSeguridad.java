package interfaces;

public interface CalculoTasaSeguridad {
	
	final double tasaSeguridad = 0.003; // 0.30 %

	double tasaseguridad(double montopagado);
	
}