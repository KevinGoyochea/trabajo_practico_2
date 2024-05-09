package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Origenes;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categorias;

public class Main {

	public static void main(String[] args) {
		short opcion=0;
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		List<Producto>lista=new ArrayList<>();
		List<Producto> compras = new ArrayList<>();
		lista.add(new Producto((short)1, "Pc gamer", 1000000 , ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.URUGUAY , Categorias.INFORMATICA, false));
		lista.add(new Producto((short)2, "Licuadora", 100000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA , Categorias.ELECTROHOGAR, true));
		lista.add(new Producto((short)3, "Destornillador con mango de goma", 59999 , ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.BRASIL , Categorias.HERRAMIENTAS, false));
		lista.add(new Producto((short)4, "Samsung flip 2", 400000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.ARGENTINA , Categorias.TELEFONIA, false));
		lista.add(new Producto((short)5, "Tester", 75000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.ARGENTINA, Categorias.HERRAMIENTAS, true));
		lista.add(new Producto((short)6, "LG Lavadora", 600000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.BRASIL, Categorias.ELECTROHOGAR, true));
		lista.add(new Producto((short)7, "Lenovo ThinkPad", 800000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.INFORMATICA, false));
		lista.add(new Producto((short)8, "iPhone 13 Pro", 1500000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.ARGENTINA, Categorias.TELEFONIA, false));
		lista.add(new Producto((short)9, "Philips Smart TV", 2000000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.ELECTROHOGAR, true));
		lista.add(new Producto((short)10, "HP Envy Laptop", 1800000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.URUGUAY, Categorias.INFORMATICA, false));
		lista.add(new Producto((short)11, "Bosch Taladro", 1300000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.HERRAMIENTAS, true));
		lista.add(new Producto((short)12, "Motorola Moto G8", 300000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.BRASIL, Categorias.TELEFONIA, false));
		lista.add(new Producto((short)13, "Samsung Refrigerador", 2500000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.ELECTROHOGAR, true));
		lista.add(new Producto((short)14, "Micro-ondas", 1500000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.URUGUAY, Categorias.ELECTROHOGAR, true));
		lista.add(new Producto((short)15, "Xiaomi Redmi Note 11", 400000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.TELEFONIA, false));
		
		do {
			;	
			try {
				System.out.println("1- Mostrar productos");
				System.out.println("2- Realizar compra");
				System.out.println("3- Salir");
				opcion=scanner.nextShort();
				scanner.nextLine();
				if(opcion>3 || opcion<1) {
					System.out.println("-------------------------------");
					System.out.println("Debe ingresar una opcion valida");
					System.out.println("-------------------------------");
				}
			}catch(Exception e) {
				System.out.println("----------------------------------------");
				System.out.println("No se aceptan los caracteres como opcion");
				System.out.println("----------------------------------------");
				scanner.nextLine();
				
			}
			switch (opcion) {
			case 1: {
				for(Producto p:lista) {
					System.out.println(p);
				}
			break;
			}
			case 2:{
				double totalPrecio = 0;
				boolean opcionPagoInvalido = true;
				char caracter = 'n';
				boolean band=true; 
				boolean encontrado=false;
				do {
					Producto productoEncontrado = null;
					System.out.println("Ingrese el codigo del producto que desea comprar");
					short buscarcodigo = scanner.nextShort();
					scanner.nextLine();
					for(Producto p: lista) {
						if (p.getCodigo()==buscarcodigo) {
							productoEncontrado=p;
							compras.add(productoEncontrado);
							encontrado=true;
							break;
						}
					}
					if (!encontrado) {
						System.out.println("-----------------------------------------");
						System.out.println("No se encontro un producto con ese codigo");
						System.out.println("-----------------------------------------");
					}
			
					System.out.println("Desea seguir comprando? (S/N)");
					String respuesta = scanner.nextLine();
					caracter = respuesta.charAt(0);
					if (caracter=='n' || caracter=='N')
						band= false;
					else {
						productoEncontrado = null;
						buscarcodigo=0;
					}
				}while(band);
				do {	
					System.out.println("Seleccione el metodo de pago (1 o 2):"+"\n"+"1- Pagar con tarjeta"+"\n"+"2- Pagar en efectivo");
					short opcionPago = scanner.nextShort();
					scanner.nextLine();
					if (opcionPago== 1) {
						System.out.println("Ha escojido pagar con tarjeta, por ende tendra un aumento del 15%");
						System.out.println("Ingrese el numero de tarjeta");
						String numeroTarjeta = scanner.nextLine();
						System.out.println("Ingrese la fecha del pago");
						LocalDate fechaPago = LocalDate.parse(scanner.nextLine(),formatoFecha);
						for(Producto p:compras) {
							p.getPrecioUnitario();
							totalPrecio += p.getPrecioUnitario();
						}	
					PagoTarjeta pago = new PagoTarjeta(numeroTarjeta, fechaPago, totalPrecio);
					pago.imprimirRecibo();	
					opcionPagoInvalido=false;
					}
					if (opcionPago==2) {
						System.out.println("Ha escojido pagar con efectivo, por ende tendra un descuento del 10%");
						System.out.println("Ingrese la fecha del pago");
						LocalDate fechaPago = LocalDate.parse(scanner.nextLine(),formatoFecha);
						for(Producto p:compras) {
							p.getPrecioUnitario();
							totalPrecio += p.getPrecioUnitario();
						}	
					PagoEfectivo pago2 = new PagoEfectivo(fechaPago, totalPrecio);
					pago2.imprimirRecibo();
					opcionPagoInvalido=false;
					}
					if (opcionPago!=1 && opcionPago!=2) {
						System.out.println(opcionPago+" No es un metodo de pago valido");
					}
				}while(opcionPagoInvalido);	
				
			}
				case 3:{
				System.out.println("Gracias por navegar"+"\n"+
									"Saliendo...");
				opcion=3;
				break;
			}
			default:
			}
		}while(opcion!=3);	
	}
}
