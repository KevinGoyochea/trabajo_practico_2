package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		FelinoSalvaje felino  = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter <FelinoSalvaje, FelinoDomestico> converter = x->new FelinoDomestico(x.getNombre(), x.getEdad(),x.getPeso());
		
		if(Converter.isNotNull(felino)) {
		
			FelinoDomestico gatoDomestico = converter.conver(felino);
			converter.mostrarObjeto(gatoDomestico);	
			
		}else
			System.out.println("El objeto es nulo");
		
	}

}
