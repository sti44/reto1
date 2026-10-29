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


	
	
	
	
	
	
}
