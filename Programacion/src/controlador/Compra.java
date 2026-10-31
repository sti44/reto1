package controlador;

public class Compra {
	public static String[] carrito = new String[50];
	public static double[] preciosCarrito = new double[50];
	public static int cantidadProductos = 0;

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

	public static double dineroIntroducido = 0;

	public static void mostrarProductosSeleccionados() {
		if (cantidadProductos == 0) {
			System.out.println("Todavia no has seleccionado ningun producto");
		} else {
			for (int i = 0; i < cantidadProductos; i++) {
				System.out.println((i + 1) + ". " + carrito[i] + " - " + preciosCarrito[i] + " €");
			}
		}
	}

	public static void mostrarProcesoDePago() {
		System.out.println("********************************");
		System.out.println("hola soy el proceso de pago jeje");
		System.out.println("********************************");

	}

	public static void calcularPago() {
		mostrarProductosSeleccionados();
		double total = 0;

	}

	public static double[] dineroPermitido = { 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00 };

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

	public static void meterDinero() {

		total = 0;

		for (int i = 0; i < cantidadProductos; i++) {
			total += preciosCarrito[i];
		}

		total = Math.round(total * 1.21 * 100) / 100.0;

		System.out.println("====== INTRODUCIR DINERO =====");
		System.out.println("Cantidad de productos: " + cantidadProductos);
		System.out.println("Total con IVA: %.2f" + total);

		for (int i = 0; i < dineroPermitido.length; i++) {
			System.out.printf("Introducir", i + 1, dineroPermitido[i]);

		}
	}

	public static void devolverDinero() {

	}

}
