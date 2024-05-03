package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
JUJUY(727780, 53200), SALTA(1300000, 155488), TUCUMAN(1700000,22524), CATAMARCA(400000,102606), LA_RIOJA(400000,89680), SANTIAGO_DEL_ESTERO(900000,136351);
	
	private double cantidadPoblacion;
	private double superficie;
	
	

	private Provincia(double cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}



	public double calcularDensidadPoblacional() {
		double densidad = cantidadPoblacion/superficie;
		return densidad;
	}



	public double getCantidadPoblacion() {
		return cantidadPoblacion;
	}



	public double getSuperficie() {
		return superficie;
	}

}
