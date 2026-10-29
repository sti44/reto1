package controlador;

import java.util.Scanner;

public class Menu {

	private static Scanner sc = new Scanner(System.in);
	// Arrays bidimensionales
	public static String[][] productos = { { "S", "M", "L", "XL" },
			{ "Ramen pollo", "Ramen marisco", "Ramen cerdo", "Ramen picante" },
			{ "Cafe", "Soda Yoongi", "Monster Energy", "Soda naranja" },
			{ "Orio", "Pockys", "Chicles sabor BTS", "Patatas Chipstar" } };

	public static double[][] precios = { { 10.00, 15.00, 25.00, 30.00 }, { 5.00, 4.50, 5.00, 5.00 },
			{ 1.50, 2.50, 3.00, 2.00 }, { 2.00, 2.50, 5.00, 3.00 } };

	// Mostrar la bienvenida
	public static void mostrarBienvenida() {
		System.out.println("***********************************************");
		System.out.println("*  Bienvenido a la máquina Elorrieta Vending  *");
		System.out.println("***********************************************");
		System.out.println();
		System.out.println("Presione cualquier tecla para continuar...");
		// Si desea entrar como administrador pulse ñ y ENTER
		// sc.nextLine();
		Admin.loginAdmin();

	}

	// Mostrar los tipos de productos
	public static int mostrarTipoProductos() {
		int opcion = 0;
		boolean valido = false;
		while (!valido) {
			System.out.println("\nSeleccione un tipo de producto:");
			System.out.println("1. Caja sorpresa");
			System.out.println("2. Ramen");
			System.out.println("3. Bebidas");
			System.out.println("4. Snacks");
			System.out.println("5. Salir");
			// Validacion de que el valor introducido es correcto
			try {
				opcion = Integer.valueOf(sc.nextLine());

				if (opcion >= 1 && opcion <= 5) {
					valido = true;
				} else {
					System.out.println("Opcion no valida");
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero valido");
			}
		}
		// Validacion de la opcion de salir
		if (opcion == 5) {
			System.out.println("¿Desea salir? \n Pulse S si si \n Pulse N si no");
			String respuesta = sc.nextLine().trim().toUpperCase();

			if (respuesta.equals("S")) {
				mostrarBienvenida();
			} else if (respuesta.equals("N")) {
				mostrarTipoProductos();
			} else {
				System.out.println("Esta mal, di si o no we");
			}

		} else {
			opcionTipoProductos(opcion);
		}
		return opcion;
	}

	// Mostrar los productos de cada tipo
	public static void opcionTipoProductos(int opcion) {

		switch (opcion) {
		case 1:
			System.out.println("=============== Caja sorpresa ===============");
			opcionProductos(0);
			preguntarMasProductos();
			break;
		case 2:
			System.out.println("=============== Ramen ===============");
			opcionProductos(1);
			preguntarMasProductos();
			break;
		case 3:
			System.out.println("=============== Bebidas ===============");
			opcionProductos(2);
			preguntarMasProductos();
			break;
		case 4:
			System.out.println("=============== Snacks ===============");
			opcionProductos(3);
			preguntarMasProductos();
			break;
		default:
			System.out.println("Numero seleccionado incorrecto");
			mostrarTipoProductos();
			break;
		}
	}

	public static boolean preguntarMasProductos() {
		boolean respuestaValida = false;
	    boolean continuarComprando = false;
	    while (!respuestaValida) {
	        System.out.println("\n¿Desea añadir más productos? (Introduce 'S' para si o 'N' para no)");
	        String respuesta = sc.nextLine().trim().toUpperCase();
	        if (respuesta.equals("S")) {	
	        	continuarComprando = true; // seguir comprando
	            respuestaValida = true;    // sale del bucle
	        } else if (respuesta.equals("N")) {
	        	continuarComprando = false; // carrito
	            respuestaValida = true;     // sale del bucle
	        } else {
	        	System.out.println("Opcion incorrecta, introduce 'S' o 'N'");
	        }
	    }
	    return continuarComprando;
	}

	public static void opcionProductos(int opcion) {
		for (int i = 0; i < productos[opcion].length; i++) {
			System.out.printf("%d. %s \t %.2f €%n", (i + 1), productos[opcion][i], precios[opcion][i]);
		}
		System.out.println("Selecciona el producto que deseas comprar:");

		int seleccion = Integer.valueOf(sc.nextLine());
		if (seleccion >= 1 && seleccion <= productos[opcion].length) {
			Compra.anadirProducto(productos[opcion][seleccion - 1], precios[opcion][seleccion - 1]);
			System.out.println("\n--- PRODUCTOS SELECCIONADOS ---");
			Compra.mostrarProductosSeleccionados();
		} else if (seleccion > 4){
			System.out.println("Opcion no valida, vuelva a intentarlo.");
		} else {
			opcionProductos(opcion);
		}
	}

	public static void mostrarCarrito() {
		System.out.println("********************************************");
		System.out.println("*	  	                           *");
		System.out.println("*	  hola soy el carrito jeje	   *");
		System.out.println("*	  	                           *");
		System.out.println("********************************************");
		Compra.mostrarProductosSeleccionados();
		System.out.println("Desea comprar los productos seleccionados? (S/N)");
		Compra.mostrarProcesoDePago();

	}

}
