package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.Categorias;
import ar.edu.unju.fi.model.Producto.Origenes;

public class Main {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		List <Producto> productos = new ArrayList<>();
		productos.add(new Producto((short)7, "celular", 19000, Origenes.ARGENTINA, Categorias.INFORMATICA));
		int opcion = 0;
		do {
			try {	
				System.out.println("1- Crear Producto");
				System.out.println("2- Mostrar Productos");
				System.out.println("3- Modificar Producto (no puede modificar el codigo)");
				System.out.println("4- Salir");
				opcion =scanner.nextInt();
				scanner.nextLine();
			}catch(Exception e) {
				System.out.println("debe ingresar un numero entero");
				System.out.println("------------------------------");
				scanner.nextLine();
				opcion=0;
			}		
			switch (opcion) {
			case 1: {
				int opcionOrigen = 0;
				int opcionCategoria = 0;
				boolean band;
				System.out.println("Ingrese el codigo del producto");
				short  codigo = scanner.nextShort();
				scanner.nextLine();
				System.out.println("Ingrese descripcion");
				String descripcion=scanner.nextLine();
				System.out.println("Ingrese el precio por unidad");
				double precioUnitario = scanner.nextDouble();
				do {
					System.out.println("Escoja el origen de fabricacion");
					for (int i=0; i < Origenes.values().length; i++) {
						Origenes o = Origenes.values()[i];
						System.out.println((i+1)+" - "+o);
						}	
						opcionOrigen =scanner.nextInt();
					if(opcionOrigen<1||opcionOrigen>4){
						System.out.println("Debe Ingresar una opcion valida");
						band=true;
					}else {
						band=false;
					}
				}while(band);		
				do {
					System.out.println("Escoja la categoria");
					for(int i=0; i < Categorias.values().length;i++) {
						Categorias c = Categorias.values()[i];
						System.out.println((i+1)+" - "+c);
					}
					opcionCategoria = scanner.nextInt();
					if(opcionCategoria<1||opcionCategoria>4) {
						System.out.println("Debe Ingresar una opcion valida");
						band = true;
					}else {
						band=false;
					}
				}while(band);
				Producto producto = new Producto(codigo, descripcion, precioUnitario, Origenes.values()[opcionOrigen-1], Categorias.values()[opcionCategoria-1]);
				productos.add(producto);
				break;
			}
			case 2: {
				for(Producto p:productos)
					System.out.println(p);
				break;
			}
			case 3: {
			    System.out.println("Ingrese código del producto que desea modificar:");
			    short buscarCodigo = scanner.nextShort();
			    scanner.nextLine(); 
			    Producto productoEncontrado = null;			   
			    for (Producto p : productos) {
			        if (p.getCodigo() == buscarCodigo) {
			            productoEncontrado = p;
			            break;
			        }
			    }	    
			    if (productoEncontrado != null) {
			        System.out.println("Seleccione el atributo que desea modificar:");
			        System.out.println("1 - Descripción");
			        System.out.println("2 - Precio unitario");
			        System.out.println("3 - Origen de fabricación");
			        System.out.println("4 - Categoría");
			        int opcionAtributo = scanner.nextInt();
			        scanner.nextLine();        
			        switch (opcionAtributo) {
			            case 1: {
			                System.out.println("Ingrese la nueva descripción del producto:");
			                String nuevaDescripcion = scanner.nextLine();
			                productoEncontrado.setDescripcion(nuevaDescripcion);
			                break;
			            }
			            case 2: {
			                System.out.println("Ingrese el nuevo precio por unidad:");
			                double nuevoPrecioUnitario = scanner.nextDouble();
			                scanner.nextLine(); 
			                productoEncontrado.setPrecioUnitario(nuevoPrecioUnitario);
			                break;
			            }
			            case 3: {
			                System.out.println("Escoja el nuevo origen de fabricación:");
			                for (int i = 0; i < Origenes.values().length; i++) {
			                    Origenes o = Origenes.values()[i];
			                    System.out.println((i + 1) + " - " + o);
			                }
			                int opcionNuevoOrigen = scanner.nextInt();
			                scanner.nextLine(); 
			                productoEncontrado.setOrigenFabricacion(Origenes.values()[opcionNuevoOrigen - 1]);
			                break;
			            }
			            case 4: {
			                System.out.println("Escoja la nueva categoría:");
			                for (int i = 0; i < Categorias.values().length; i++) {
			                    Categorias c = Categorias.values()[i];
			                    System.out.println((i + 1) + " - " + c);
			                }
			                int opcionNuevaCategoria = scanner.nextInt();
			                scanner.nextLine(); 
			                productoEncontrado.setCategoria(Categorias.values()[opcionNuevaCategoria - 1]);
			                break;
			            }
			            default: {
			                System.out.println("Opción no válida");
			                break;
			            }
			        }
			        System.out.println("Producto modificado exitosamente.");
			    } else {
			        System.out.println("No se encontró ningún producto con ese código.");
			    }
			    break;
			}
			case 4: {
				System.out.println("Gracias por navegar"+"\n"+
									"Saliendo...");
				break;
			}
			default:
				System.out.println("Debe ingresar un numero que este entre las opciones");
				System.out.println("---------------------------------------------------");
			}
		}while(opcion!=4);
	}	
}
