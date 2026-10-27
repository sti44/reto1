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
			System.out.print("Modo Empleado Activado");
		} else {
			System.out.println("Contraseña Incorrecta. Inténtelo de nuevo.");
			Menu.mostrarBienvenida();
			sc.nextLine();
		}
		
	}
}
