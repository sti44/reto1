package controlador;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void mostrarBienvenida() {
		System.out.println("***********************************************");
		System.out.println("*  Bienvenido a la máquina Elorrieta Vending  *");
		System.out.println("***********************************************");
		System.out.println();
		System.out.println("Presione ENTER para continuar...");
		sc.nextLine();
	}

	public static int mostrarTipoProductos() {
		int opcion = 0;
		boolean valido = false;
		while(!valido) {
			System.out.println("\nSeleccione una categoría de productos:");
			System.out.println("1. Caja sorpresa");
			System.out.println("2. Ramen");
			System.out.println("3. Bebidas");
			System.out.println("4. Snacks");
			System.out.println("5. Salir");
			opcion = Integer.valueOf(sc.nextLine());
			
			try {
				if(opcion >= 1 && opcion <= 5) {
					valido = true;
				} else {
					System.out.println("Opcion no valida");
				}
			}catch(NumberFormatException e){
				System.out.println("Introduce un numero valido");
			}
		}
			if(opcion == 5) {
				System.out.println("¿Desea salir? \n Pulse S si si \n Pulse N si no");
				String respuesta = sc.nextLine().trim().toUpperCase(); 
				
				if(respuesta.equals("S")) {
					mostrarBienvenida();
				}else {
					mostrarTipoProductos();
				}
				
			}else {
				opcionTipoProductos(opcion);
			}
		return opcion;
	}
	
	public static void opcionTipoProductos(int opcion) {	
		switch (opcion) {
		case 1:
			System.out.println("=============== Caja sorpresa ===============");
			System.out.println("\t 1. S \t");
			System.out.println("\t 2. M \t");
			System.out.println("\t 3. L \t");
			System.out.println("\t 4. XL \t");
			int opcionProducto = Integer.valueOf(sc.nextLine());
			mostrarCarrito();
			break;
		case 2:
			System.out.println("=============== Ramen ===============");
			System.out.println("\t 1. Sabor pollo \t");
			System.out.println("\t 2. Sabor marisco \t");
			System.out.println("\t 3. Sabor cerdo \t");
			System.out.println("\t 4. Picante \t");
			mostrarCarrito();
			break;
		case 3:
			System.out.println("=============== Bebidas ===============");
			System.out.println("\t 1. Café \t");
			System.out.println("\t 2. Soda Yoongi \t");
			System.out.println("\t 3. Monster Energy \t");
			System.out.println("\t 4. Soda sabor naranja \t");
			mostrarCarrito();
			break;
		case 4:
			System.out.println("=============== Snacks ===============");
			System.out.println("1. Oreo");
			System.out.println("2. Pockys");
			System.out.println("3. Chicles");
			System.out.println("4. Patatas Chipstar");
			mostrarCarrito();
			break;
		default:
			System.out.println("Numero seleccionado incorrecto");
			break;
		}
		
	}

	private static void mostrarCarrito() {
		System.out.println("hola soy el carrito jeje");
		
	}

}
