package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categorias;
import ar.edu.unju.fi.ejercicio5.model.Producto.Origenes;

public class Main {
	public static void main(String[] args) {
		short opcion;
		Scanner scanner = new Scanner(System.in);
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto((short)1, "Pc gamer", 1000000 , ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.URUGUAY , Categorias.INFORMATICA, false));
		productos.add(new Producto((short)2, "Licuadora", 100000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA , Categorias.ELECTROHOGAR, true));
		productos.add(new Producto((short)3, "Destornillador con mango de goma", 59999 , ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.BRASIL , Categorias.HERRAMIENTAS, false));
		productos.add(new Producto((short)4, "Samsung flip 2", 400000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.ARGENTINA , Categorias.TELEFONIA, false));
		productos.add(new Producto((short)5, "Tester", 75000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.ARGENTINA, Categorias.HERRAMIENTAS, true));
		productos.add(new Producto((short)6, "LG Lavadora", 600000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.BRASIL, Categorias.ELECTROHOGAR, true));
		productos.add(new Producto((short)7, "Lenovo ThinkPad", 800000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.INFORMATICA, false));
		productos.add(new Producto((short)8, "iPhone 13 Pro", 1500000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.ARGENTINA, Categorias.TELEFONIA, false));
		productos.add(new Producto((short)9, "Philips Smart TV", 2000000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.ELECTROHOGAR, true));
		productos.add(new Producto((short)10, "HP Envy Laptop", 1800000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.URUGUAY, Categorias.INFORMATICA, false));
		productos.add(new Producto((short)11, "Bosch Taladro", 1300000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.HERRAMIENTAS, true));
		productos.add(new Producto((short)12, "Motorola Moto G8", 300000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.BRASIL, Categorias.TELEFONIA, false));
		productos.add(new Producto((short)13, "Samsung Refrigerador", 2500000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.ELECTROHOGAR, true));
		productos.add(new Producto((short)14, "Micro-ondas", 1500000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.URUGUAY, Categorias.ELECTROHOGAR, true));
		productos.add(new Producto((short)15, "Xiaomi Redmi Note 11", 400000, ar.edu.unju.fi.ejercicio5.model.Producto.Origenes.CHINA, Categorias.TELEFONIA, false));
		
		do {
			try {	
				System.out.println("1- Mostrar productos");
				System.out.println("2- Mostrar productos faltantes");
				System.out.println("3- Incrementar los precios de los productos en un 20%");
				System.out.println("4- Mostrar porductos de la categoria Electrohogar que esten disponibles");
				System.out.println("5- Ordenar los productos por precio");
				System.out.println("6- Mostrar productos con nombres en Mayusculas");
				System.out.println("7- Salir");
				opcion =scanner.nextShort();
				scanner.nextLine();
			}catch(Exception e) {
				System.out.println("debe ingresar un numero entero");
				System.out.println("------------------------------");
				scanner.nextLine();
				opcion=0;
			}		
			switch (opcion) {
			case 1: {
				Consumer<Producto> printConsumer = p -> {
					if(p.isEstado()) {
						System.out.println(p);
					}
				};
				productos.forEach(printConsumer);
				break;
			}
			case 2: {
				Predicate<Producto> filterEstadoFals = p->!p.isEstado();
				productos.stream().filter(filterEstadoFals).forEach(System.out::println);
				break;
				
			}
			case 3: {
			   Function<Producto, Producto> funcionIncrementar =(p)->{
				   double resultado = p.getPrecioUnitario()+(p.getPrecioUnitario()*1.20);
				   p.setPrecioUnitario(resultado);
				   return p;
			   };
			   List<Producto> productosAumentados = new ArrayList<>();
			   productosAumentados = productos.stream().map(funcionIncrementar).collect(Collectors.toList());
			   productosAumentados.forEach(System.out::println);
			    break;
			}
			case 4: {
				Predicate<Producto> filterCategoriaDisponible = p->p.getCategoria().equals(Producto.Categorias.ELECTROHOGAR) && p.isEstado();
				productos.stream().filter(filterCategoriaDisponible).forEach(System.out::println);
				break;
			}
			case 5:{
				productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
				productos.forEach(System.out::println);
			}
			case 6:{
				Function<Producto, Producto> funcionMayuscula = (p) -> {
					if (p.getDescripcion().equals(p.getDescripcion().toUpperCase())) {
						return p;
					}
					return null;
				};
				List<Producto> productosMayuscula = new ArrayList<>();
				productosMayuscula=productos.stream().map(funcionMayuscula).filter(p -> p !=null).collect(Collectors.toList());
				productosMayuscula.forEach(System.out::println);
			}
			case 7:{
				System.out.println("Gracias por navegar"+"\n"+
									"Saliendo...");
				break;
			}
			default:
				System.out.println("Debe ingresar un numero que este entre las opciones");
				System.out.println("---------------------------------------------------");
			}
		}while(opcion!=7);
		
	}
	
}
