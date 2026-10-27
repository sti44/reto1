package controlador;

import java.util.Scanner;

public class Admin {

	private static Scanner sc = new Scanner(System.in);

	private static String userAdmin = "ñ";
	private static String claveAdmin = "creeper";

	// Validar si el usuario y contraseña de admin es correcto
	// Si no es correcto, vuelve a la Bienvenida del programa
	public static void loginAdmin() {
		String usuarioIntroducido = sc.nextLine();

		if (usuarioIntroducido.equalsIgnoreCase(userAdmin)) {
			validarClave();
		} else {
			Menu.mostrarTipoProductos();
		}
	}

	public static void validarClave() {

		String claveIntroducida = sc.nextLine();

		if (claveIntroducida.equalsIgnoreCase(claveAdmin)) {
			System.out.println("Modo Empleado Activado");
			mostrarMenuAdmin();
		} else {
			System.out.println("Contraseña Incorrecta. Inténtelo de nuevo.");
			Menu.mostrarBienvenida();
			sc.nextLine();
		}

	}

	public static void mostrarMenuAdmin() {
		System.out.println("===============================================");
		System.out.println("             Opciones de Empleado              ");
		System.out.println("===============================================");
		System.out.println();
		System.out.println("RECUERDE");
		System.out.println();
		System.out.println("Debe haber un máximo de 5 productos por cada tipo");
		System.out.println();
		System.out.println("1. Nuevo Producto");
		System.out.println("2. Modificar Producto");
		System.out.println("3. Eliminar Producto");
		System.out.println("4. Salir");
		opcionValidaAdmin();
	}

	public static int opcionValidaAdmin() {
		int opcion = 0;
		boolean valido = false;
		while (!valido) {
			System.out.println("\nSeleccione la acción deseada: ");
			// Validación de que el valor introducido es correcto
			try {
				opcion = Integer.valueOf(sc.nextLine());

				if (opcion >= 1 && opcion <= 4) {
					valido = true;
				} else {
					System.out.println("Opción no valida");
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un número valido");
			}
		}
		// Validación de la opción de salir
		if (opcion == 4) {
			System.out.println("¿Desea salir? \n Pulse S si confirma salir \n Pulse N si no quiere salir del modo Empleado");
			String respuesta = sc.nextLine().trim().toUpperCase();

			if (respuesta.equals("S")) {
				Menu.mostrarBienvenida();
			} else if (respuesta.equals("N")) {
				mostrarMenuAdmin();
			} else {
				System.out.println("Opción no válida, introduzca S o N, por favor.");
			}

		} else {
			opcionesAdmin(opcion);
		}
		return opcion;

	}

	public static void opcionesAdmin(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Nuevo Producto");
			break;
		case 2:
			System.out.println("Modificar Producto");
			break;
		case 3:
			System.out.println("Eliminar Producto");
			break;
		default:
			System.out.println("Número seleccionado incorrecto");
			break;
		}
		
	}
}
