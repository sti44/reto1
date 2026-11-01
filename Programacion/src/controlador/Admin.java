package controlador;

import java.util.Scanner;

public class Admin {

	private static Scanner sc = new Scanner(System.in);

	private static String userAdmin = "ñu";
	private static String claveAdmin = "creeper";

	// Comprobar el usuario: 
	// Coincide el usuario: comprueba la clave y si se valida muestra el menú de admin.
	// No coincide con el usuario: muestra los tipos de productos para el usuario estándar
	public static void tipoUser() {
		String usuarioIntroducido = sc.nextLine();

		if (usuarioIntroducido.equalsIgnoreCase(Admin.userAdmin)) {
			// Validar si la clave de Admin es correcta.
			boolean admin = validarClave();
			if (admin) {
				opcionesAdmin();;
			} else if (!admin) {
				Menu.mostrarBienvenida();
			}
		} else {
			Menu.mostrarTipoProductos();
		}
	}
	
	// Comprobar clave:
	// La clave es correcta: entra en Modo Empleado
	// La clave no es correcta: vuelve a la Bienvenida del programa
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
		switch (accionValidaAdmin(opcion)) {
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

	// Valida si la acción de Admin introducida es un número que se encuentra entre las opciones ofrecidas.
	public static int accionValidaAdmin(int accion) {
		boolean valida = false;
		System.out.println("\nSeleccione la acción deseada: ");
		do {
			// Validación de que el valor introducido es correcto
			try {
				accion = Integer.valueOf(sc.nextLine());

				if (accion >= 1 && accion <= 4) {
					valida = true;
				} else {
					System.out.println("Opción no valida");
					valida = false;
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un número valido");
			}
		} while (!valida);
		return accion;
	}

	// Validación para salir del Modo Admin. Vuelve al menú de Bienvenida del inicio.
	public static void salirModoAdmin() {
		System.out.println("¿Desea salir del Modo Empleado? \n Salir \n Continuar");
		String respuesta = sc.nextLine().trim().toUpperCase();

		if (respuesta.equalsIgnoreCase("salir")) {
			Menu.mostrarBienvenida();
		} else if (respuesta.equalsIgnoreCase("continuar")) {
			opcionesAdmin();
		} else {
			System.out.println("Opción no válida, escriba salir o continuar, por favor.");
		}

	}

	// Validación para salir de una acción de Admin. Vuelve al menú del Admin.
	public static boolean salirOpcionAdmin() {
		String respuesta = "";
		boolean salir = false;
		do {
			System.out.println(
					"¿Desea volver al menú o continuar? \n Volver. \n Continuar.");
			respuesta = sc.nextLine().trim().toUpperCase();

			if (!respuesta.equalsIgnoreCase("volver") && !respuesta.equalsIgnoreCase("continuar")) {
				System.out.println("Opción no válida, escriba volver o continuar, por favor.");
			}

		} while (!respuesta.equalsIgnoreCase("volver") && !respuesta.equalsIgnoreCase("continuar"));

		if (respuesta.equalsIgnoreCase("volver")) {
			salir = true;
		}
		return salir;
	}

	// Valida si el tipo de producto es un número que se encuentra entre las opciones ofrecidas.
	public static int validaTipoDeProductoAdmin() {
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

				if (opcion >= 1 && opcion <= 4) {
					if (comprobarHuecosProducto(opcion - 1) == -1) {
						return 0;
					} else {
						valido = true;
					}
				} else if (opcion == 5) {
					if (salirOpcionAdmin()) {
						return 0;
					} 
				} else {
					System.out.println("Opción no valida");
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un número válido");
			}
		}

		return opcion;
	}
	
	// Método para añadir productos
	public static void nuevoProducto() {
		int tipoProductoElegido = validaTipoDeProductoAdmin();
		int indexTipoProductoElegido = tipoProductoElegido - 1;
		
		switch (tipoProductoElegido) {
		case 0:
			opcionesAdmin();
			break;
		case 1:
			listaProductosActuales(tipoProductoElegido);
			break;
		case 2:
			listaProductosActuales(indexTipoProductoElegido);
			break;
		case 3:
			listaProductosActuales(indexTipoProductoElegido);
			break;
		case 4:
			listaProductosActuales(indexTipoProductoElegido);
			break;
		
		default:
			System.out.println("Seleccione un tipo de producto válido, por favor.");
			break;
		}

	}

	public static void listaProductosActuales(int indexTipoProductoElegido) {
		System.out.println();
		System.out.println("Lista de productos actuales: ");
		for (int i = 0; i < modelo.Modelo.maxProductos - 1; i++) {
			System.out.printf("%d. %s \t %.2f €%n", (i + 1), modelo.Modelo.productos[indexTipoProductoElegido][i],
					modelo.Modelo.precios[indexTipoProductoElegido][i]);
		}
		
	}

	public static void añadirProducto(int tipoProductoElegido) {
		int indice = modelo.Modelo.maxProductos -1;
		System.out.println("Introduzca el nombre del nuevo producto:");
		String nombre = sc.nextLine();
		
		
	}

	// Comprueba si hay huecos en el array de productos:
	// 		Hay hueco: pregunta si quiere continuar o salir.
	//		No hay hueco: vuelve al menú de Admin 
	public static int comprobarHuecosProducto(int tipoProductoElegido) {

		if (modelo.Modelo.productos[tipoProductoElegido][modelo.Modelo.maxProductos - 1].equalsIgnoreCase("")) {
			System.out.println("Tenemos hueco para un nuevo producto.");
			if (salirOpcionAdmin()) {
				return -1;
			} 
		} else {
			System.out.println("No tenemos hueco para un nuevo producto.");
			return -1;
		}
		return tipoProductoElegido;
	}

	

	
}
