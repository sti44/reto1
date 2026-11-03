package controlador;

import java.util.Iterator;
import java.util.Scanner;

public class Compra {
	public static String[] carrito = new String[50];
	public static double[] preciosCarrito = new double[50];
	public static int cantidadProductos = 0;

	private static Scanner sc = new Scanner(System.in);

	public static void anadirProducto(String producto, double precio) {
		if (cantidadProductos < carrito.length) {
			carrito[cantidadProductos] = producto;
			preciosCarrito[cantidadProductos] = precio;
			cantidadProductos++;
		} else {
			System.out.println("El carrito esta lleno");
		}
	}

	public static double total = 0;

	public static double dineroIntroucidoTotal = 0;

	public static void mostrarProductosSeleccionados() {
		if (cantidadProductos == 0) {
			System.out.println("Todavia no has seleccionado ningun producto");
		} else {
			for (int i = 0; i < cantidadProductos; i++) {
				System.out.println((i + 1) + ". " + carrito[i] + " - " + preciosCarrito[i] + " €");
			}
		}
	}

	public static void mostrarProductosConIVA() {
		if (cantidadProductos == 0) {
			System.out.println("No hay productos en el carrito.");
			return;
		}

		double subtotalGeneral = 0.0;
		double totalConIvaGeneral = 0.0;

		for (int i = 0; i < cantidadProductos; i++) {
			String nombre = carrito[i];
			double precioSinIva = preciosCarrito[i];

			double precioConIva = precioSinIva * 1.21;
			subtotalGeneral += precioSinIva;
			totalConIvaGeneral += precioConIva;

			System.out.printf("- %s \t Precio: %.2f € \t Precio con IVA(21%%): %.2f €%n", nombre, precioSinIva,
					precioConIva);
		}

		System.out.println("----------------------------------------------");
		System.out.printf("SUBTOTAL: %.2f €%n", subtotalGeneral);
		System.out.printf("TOTAL A PAGAR (con IVA): %.2f €%n", totalConIvaGeneral);
		System.out.println("==============================================");
	}

	public static void vaciarCarrito() {
		cantidadProductos = 0;
		for (int i = 0; i < carrito.length; i++) {
			carrito[i] = null;
			preciosCarrito[i] = 0.0;
		}
	}

	public static void mostrarProcesoDePago() {
		System.out.println("********************************");
		System.out.println("Proceso de pago");
		System.out.println("********************************");

		meterDinero();
	}

	public static void calcularPago() {
		mostrarProductosSeleccionados();

	}

	public static double[] dineroPermitido = { 0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00,
			50.00 };

	public static void eliminarProductos(int borrarProducto) {

		boolean borrar = true;
		for (int i = borrarProducto; i < carrito.length && borrar; i++) {
			if (carrito[i + 1] != null && 1 + i < carrito.length) {
				carrito[i] = carrito[i + 1];
				preciosCarrito[i] = preciosCarrito[1 + i];

			} else {
				borrar = false;
			}

		}

	}

	public static double meterDinero() {

		total = 0;

		for (int i = 0; i < cantidadProductos; i++) {
			total += preciosCarrito[i];
		}

		total = Math.round(total * 1.21 * 100) / 100.0;

		System.out.println("====== INTRODUCIR DINERO =====");
		System.out.println("Cantidad de productos: " + cantidadProductos);
		System.out.printf("Total con IVA: %.2f", total);
		System.out.println();

		for (int i = 0; i < dineroPermitido.length; i++) {
			System.out.printf("Introducir \t %5.2f \n", dineroPermitido[i]);

		}

		boolean dineroSuficiente = false;
		double dineroIntroducidoTotal = 0;
		do {
			System.out.println("===== Introduce las monedas validas =====");
			double dineroIntroducido = Double.parseDouble(sc.nextLine());
			dineroIntroducidoTotal += dineroIntroducido;
			System.out.println(dineroIntroducidoTotal);
			if (dineroIntroducidoTotal >= total) {
				dineroIntroducidoTotal -= total;
				dineroSuficiente = true;
			}
		} while (!dineroSuficiente);

		return dineroIntroducidoTotal;
	}

	public static void devolverDinero() {

		double total = 10;
		double dineroIntroducido = 138.98;
		double[] dineroPermitido = { 0.01, 0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00 };

		if (dineroIntroducido < total) {
			System.out.println("Dinero insuficiente. Por favor, introduzca más dinero.");
		} else {
			double cambio = dineroIntroducido - total;
			System.out.println("Cambio a devolver: " + cambio);
			System.out.println("Desglose del cambio:");

			for (int i = dineroPermitido.length - 1; i >= 0; i--) {
				int cantidadMonedas = (int) (cambio / dineroPermitido[i]);
				if (cantidadMonedas > 0) {
					System.out.println(cantidadMonedas + " moneda(s) de " + dineroPermitido[i]);
					cambio -= cantidadMonedas * dineroPermitido[i];
				}
			}
		}

	}

}
