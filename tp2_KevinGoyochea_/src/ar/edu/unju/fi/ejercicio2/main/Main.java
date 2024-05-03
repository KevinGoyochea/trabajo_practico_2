package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	public static void main(String[] args) {
		List<Efemeride> efemerides = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
			try {
				System.out.println("1- Crear efemeride");
				System.out.println("2- Mostrar efemeride");
				System.out.println("3- Eliminar efemeride");
				System.out.println("4- Modificar efemeride");
				System.out.println("5- Salir");
				opcion=scanner.nextInt();
				switch (opcion) {
				case 1: {
					short opcionMes;
					boolean band;
					System.out.println("Ingrese codigo");
					short codigo = scanner.nextShort();
					scanner.nextLine();
					do {
						System.out.println("Ingrese mes (1-12)");
						opcionMes = scanner.nextShort();
						scanner.nextLine();
						if(opcionMes<1 || opcionMes>12) {
							System.out.println("-------------------------------");
							System.out.println("Debe ingresar una opcion valida");
							System.out.println("-------------------------------");
							band=true;
						}else {
							band=false;
						}	
					}while(band);
					System.out.println("Ingrese dia");
					short dia = scanner.nextShort();
					scanner.nextLine();
					System.out.println("ingrese detalles");
					String detalle = scanner.nextLine();
					Efemeride efemeride = new Efemeride(codigo, Mes.values()[opcionMes-1], dia, detalle);
					efemerides.add(efemeride);
				break;
				}
				case 2:{
					for(Efemeride e:efemerides) {
						System.out.println(e);		
					}					
				break;	
				}
				case 3:{
					boolean efemerideEncontrada = false;
					System.out.println("Ingrese el codigo de la efemeride que desea eliminar");
					short buscarEfemeride = scanner.nextShort();
					for (Iterator<Efemeride> iterator = efemerides.iterator();iterator.hasNext();) {
						Efemeride efemeride = iterator.next();
						if(efemeride.getCodigo()==buscarEfemeride) {
							iterator.remove();
							System.out.println("La efemeride ha sido eliminada");
							efemerideEncontrada=true;
							break;
						}
					}
					if(!efemerideEncontrada) {
						System.out.println("------------------------------------------------------------");
						System.out.println("El codigo ingresado no concuerda con el de ninguna efemeride");
						System.out.println("------------------------------------------------------------");
					}
				break;
				}
				case 4:{
					boolean bandera;
					short nuevoMes;
					Efemeride efemerideEncontrada = null;
					System.out.println("Ingrese el codigo de la efemeride que desea modificar ");
					short buscarCodigo=scanner.nextShort();
					for(Efemeride e:efemerides) {
						if(e.getCodigo()==buscarCodigo) {
							efemerideEncontrada=e;
							break;	
						}
					}	
					if(efemerideEncontrada!=null) {
						do {
							System.out.println("Ingre nuevo mes(1-12)");
							nuevoMes = scanner.nextShort();
							scanner.nextLine();
							if(nuevoMes<1 || nuevoMes>12) {
								System.out.println("-------------------------------");
								System.out.println("Debe ingresar una opcion valida");
								System.out.println("-------------------------------");
								bandera=true;
							}else {
								bandera=false;
							}
							}while(bandera);
							System.out.println("Ingrese nuevo dia");
							short nuevodia = scanner.nextShort();
							scanner.nextLine();
							System.out.println("Ingrese nuevos detalles");
							String nuevosDetalles = scanner.nextLine();
							efemerideEncontrada.setMes(Mes.values()[nuevoMes-1]);
							efemerideEncontrada.setDia(nuevodia);
							efemerideEncontrada.setDetalle(nuevosDetalles);
							}else {
								System.out.println("-------------------------------");
								System.out.println("Debe ingresar una opcion valida");
								System.out.println("-------------------------------");
							}
				break;	
				}
				case 5:{
					System.out.println("Gracias por navegar");
				break;	
				}
				default:
					System.out.println("-------------------------------");
					System.out.println("Debe ingresar una opcion valida");
					System.out.println("-------------------------------");
				}
			}catch(Exception e) {
				System.out.println("-------------------------------");
				System.out.println("Debe ingresar una opcion valida");
				System.out.println("-------------------------------");
			}finally {
				scanner.nextLine();
			}
		}while(opcion!=5);
	}
}
