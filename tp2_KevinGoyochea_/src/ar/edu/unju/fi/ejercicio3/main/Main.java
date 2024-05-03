package ar.edu.unju.fi.ejercicio3.main;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	public static void main(String[] args) {
		ArrayList<Provincia> listaProvincias = new ArrayList <>();
		DecimalFormat df = new DecimalFormat("#.##");
		for (Provincia p: Provincia.values()) {
			listaProvincias.add(p);
			System.out.println(p+" "+"Poblacion: "+p.getCantidadPoblacion()+" "+"Superficie: "+ p.getSuperficie()+" "+"Densidad poblacional: "+df.format(p.calcularDensidadPoblacional())+" personas/km^2");
		}

	}
}