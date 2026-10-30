package controlador;

import java.util.Scanner;

public class Admin {

	private static Scanner sc = new Scanner(System.in);

	private static String userAdmin = "ñu";
	private static String claveAdmin = "creeper";

	// Si la clave es correcta entra en Modo Empleado
	// Si la clave no es correcta, vuelve a la Bienvenida del programa
	public static boolean validarClave() {
		System.out.println("Introduzca la clave de Administrador: ");
		String claveIntroducida = sc.nextLine();
		boolean adminValidado = false;

		if (claveIntroducida.equalsIgnoreCase(claveAdmin)) {
			System.out.println("");
			System.out.println("Contraseña correcta");
			System.out.println("");
			System.out.println("** Modo Empleado Activado **");
			System.out.println("");
			adminValidado = true;
		} else {
			System.out.println("Contraseña Incorrecta.");
			System.out.println();
			adminValidado = false;
		}
		return adminValidado;
	}

	public static void opcionesAdmin() {
		Menu.mostrarMenuAdmin();
		int opcion = -1;
		switch (opcionValidaAdmin(opcion)) {
		case 1:
			System.out.println("Añadir nuevo Producto");
			nuevoProducto();
			break;
		case 2:
			System.out.println("Modificar Producto");

			break;
		case 3:
			System.out.println("Eliminar Producto");
			break;
		case 4:
			salirModoAdmin();
			break;
		default:
			System.out.println("Número seleccionado incorrecto");
			break;
		}

	}

	// Comprueba si la opción del menú Admin elegida es válida
	public static int opcionValidaAdmin(int opcion) {
		boolean valido = false;
		System.out.println("\nSeleccione la acción deseada: ");
		do {
			// Validación de que el valor introducido es correcto
			try {
				opcion = Integer.valueOf(sc.nextLine());

				if (opcion >= 1 && opcion <= 4) {
					valido = true;
				} else {
					System.out.println("Opción no valida");
					valido = false;
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un número valido");
			}
		} while (!valido);
		return opcion;
	}

	// Validación de la opción de salir del Modo Admin
	public static void salirModoAdmin() {
		System.out.println("¿Desea salir? \n Pulse S para salir \n Pulse N para quedarse en Modo Empleado");
		String respuesta = sc.nextLine().trim().toUpperCase();

		if (respuesta.equals("S")) {
			Menu.mostrarBienvenida();
		} else if (respuesta.equals("N")) {
			opcionesAdmin();
		} else {
			System.out.println("Opción no válida, introduzca S o N, por favor.");
		}

	}
	
	public static void salirOpcionAdmin() {
		System.out.println("¿Desea continuar? \n Pulse S para continuar \n Pulse N para volver a las opciones de Modo Empleado");
		String respuesta = sc.nextLine().trim().toUpperCase();

		if (respuesta.equals("S")) {
			Menu.mostrarBienvenida();
		} else if (respuesta.equals("N")) {
			Menu.mostrarMenuAdmin();
		} else {
			System.out.println("Opción no válida, introduzca S o N, por favor.");
		}

	}

	// Método para añadir productos
	public static void nuevoProducto() {
		int tipoProductoElegido = menuTipoDeProducto();

		switch (tipoProductoElegido) {
		case 1:
			int indexTipoProductoElegido = tipoProductoElegido - 1;
			System.out.println();
			System.out.println("Lista de productos actuales: ");
			for (int i = 0; i < modelo.Modelo.maxProductos - 1; i++) {
				System.out.printf("%d. %s \t %.2f €%n", (i + 1), modelo.Modelo.productos[indexTipoProductoElegido][i],
						modelo.Modelo.precios[indexTipoProductoElegido][i]);
			}
			
			break;
		case 2:
			indexTipoProductoElegido = tipoProductoElegido - 1;
			System.out.println();
			System.out.println("Lista de productos actuales: ");
			for (int i = 0; i < modelo.Modelo.maxProductos - 1; i++) {
				System.out.printf("%d. %s \t %.2f €%n", (i + 1), modelo.Modelo.productos[indexTipoProductoElegido][i],
						modelo.Modelo.precios[indexTipoProductoElegido][i]);
			}
			break;
		case 3:
			indexTipoProductoElegido = tipoProductoElegido - 1;
			System.out.println();
			System.out.println("Lista de productos actuales: ");
			for (int i = 0; i < modelo.Modelo.maxProductos - 1; i++) {
				System.out.printf("%d. %s \t %.2f €%n", (i + 1), modelo.Modelo.productos[indexTipoProductoElegido][i],
						modelo.Modelo.precios[indexTipoProductoElegido][i]);
			}
			break;
		case 4:
			indexTipoProductoElegido = tipoProductoElegido - 1;
			System.out.println();
			System.out.println("Lista de productos actuales: ");
			for (int i = 0; i < modelo.Modelo.maxProductos - 1; i++) {
				System.out.printf("%d. %s \t %.2f €%n", (i + 1), modelo.Modelo.productos[indexTipoProductoElegido][i],
						modelo.Modelo.precios[indexTipoProductoElegido][i]);
			}
			break;

		default:
			System.out.println("Seleccion un tipo de producto válido, por favor.");
			break;
		}

	}

	public static void añadirProducto() {
		
		
	}

	public static int comprobarHuecosProducto(int tipoProductoElegido) {

		if (modelo.Modelo.productos[tipoProductoElegido][modelo.Modelo.maxProductos - 1].equalsIgnoreCase("")) {
			System.out.println("Tenemos hueco para un nuevo producto.");
			salirOpcionAdmin();
		} else {
			System.out.println("No tenemos hueco para un nuevo producto.");
			Menu.mostrarMenuAdmin();
		}
		return tipoProductoElegido;
	}

	public static int menuTipoDeProducto() {
		int opcion = -1;
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

				if (opcion > 0 && opcion <= 5) {
					valido = true;
				} else {
					System.out.println("Opción no valida");
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un número válido");
			}
		}
		comprobarHuecosProducto(opcion - 1);
		return opcion;
	}

	// Validar si el tipo de usuario es admin o no.
	public static void tipoUser() {
		String usuarioIntroducido = sc.nextLine();

		if (usuarioIntroducido.equalsIgnoreCase(Admin.userAdmin)) {
			// Validar si la clave de Admin es correcta.
			boolean admin = validarClave();
			if (admin) {
				Menu.mostrarMenuAdmin();
			} else if (!admin) {
				Menu.mostrarBienvenida();
			}
		} else {
			Menu.mostrarTipoProductos();
		}
	}
}
