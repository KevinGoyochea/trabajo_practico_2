package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			List<Jugador> jugadores = new ArrayList<>();
			Scanner scanner = new Scanner (System.in);
			boolean band = true;
			int opcion=0;
			do {
				;	
				try {
					System.out.println("1- Alta de jugador");
					System.out.println("2- Mostrar todos los jugadores");
					System.out.println("3- Modificar la posicion de un jugador");
					System.out.println("4- Eliminar un jugador");
					System.out.println("5- Salir");
					opcion=scanner.nextInt();
					scanner.nextLine();
					if(opcion>5 || opcion<1) {
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
					int opcionPosicion=0;
					try {
						System.out.println("Ingrese el nombre del jugador");
						String nombre = scanner.nextLine();
						System.out.println("Ingrese el apellido del jugador");
						String apellido = scanner.nextLine();
						System.out.println("Ingrese fecha de nacimineto (dd/MM/yyyy)");
						LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(),formatoFecha);
						System.out.println("Ingrese la nacionalidad del jugador");
						String nacionalidad = scanner.nextLine();
						System.out.println("Ingrese la estatura del jugador");
						float estatura = scanner.nextFloat();
						System.out.println("Ingrese el peso del jugador");
						float peso = scanner.nextFloat();
						boolean band1;
						do {
							System.out.println("Elija la posicion del jugador, seleccione una de las opciones");
							for(int i=0;i < Posicion.values().length;i++) {
								Posicion p = Posicion.values()[i];
								System.out.println((i+1)+"-"+p);
							}
							opcionPosicion=scanner.nextInt();
							if(opcionPosicion<1 || opcionPosicion>5) {
								System.out.println("Debe ingresar una opcion valida");
								band1=true;
							}else {
								band1=false;
							}
						}while(band1);
						Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.values()[opcionPosicion -1] );
						jugadores.add(jugador);
					}catch(Exception e) {
						System.out.println("------------------------------------------");
						System.out.println("Debe ingresar datos validos en cada casilla");
						System.out.println("------------------------------------------");
					}
				break;
				}
				case 2:{
					for(Jugador j:jugadores) {
						System.out.println(j);
					}
				break;	
				}
				case 3:{
					Jugador jugadorEncontrado = null;
					boolean band2;
					int nuevaPoscicion=0;
					System.out.println("Ingrese el nombre del jugador del que desea cambiar la posicion");
					String buscarNombre = scanner.nextLine();
					System.out.println("Ingrese el apellido del jugador del que desea cambiar la posicion");
					String buscarApellido = scanner.nextLine();
					try {
						for(Jugador j:jugadores) {
							if(j.getNombre().equalsIgnoreCase(buscarNombre) && j.getApellido().equalsIgnoreCase(buscarApellido)) {
								jugadorEncontrado=j;
								if(jugadorEncontrado != null) {
									do {
										System.out.println("Ingrese la nueva posicion para el jugador: "+j.getNombre()+" "+j.getApellido());
										for(int i=0;i < Posicion.values().length;i++) {
											Posicion p = Posicion.values()[i];
											System.out.println((i+1)+"-"+p);
										}
										int nuevaPosicion=scanner.nextInt();
										if(nuevaPosicion<1 || nuevaPosicion>5) {
											System.out.println("Debe ingresar una opcion valida");
											band2=true;
										}else {
											band2=false;
											jugadorEncontrado.setPosicion(Posicion.values()[nuevaPosicion-1]);
										}
									}while(band2);
								}
							}
						}
					}catch(Exception e) {
						
					}
				break;	
				}
				case 4 :{
					System.out.println("Los jugadores disponibles son:");
					for(int i=0; i < jugadores.size();i++) {
						System.out.println((i+1)+"-"+jugadores.get(i));
					}
					System.out.println("Escoja al jugador que desea eliminar(ingrese el numero correspondiente)");
					int eliminarJugador = scanner.nextInt();
					if (eliminarJugador<1 || eliminarJugador>jugadores.size()) {
						System.out.println("Escoja un opcion valida");
					}else {
						jugadores.remove(eliminarJugador-1);
						System.out.println("El jugador ha sido eliminado");
					}
					
				break;	
				}
				case 5 :{
					System.out.println("Gracias por navegar");
					System.out.println("Saliendo...");
					band=false;
				break;	
				}
				default:
				}
			}while(band);	
		}

	}
