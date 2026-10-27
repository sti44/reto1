package controlador;

public class Compra {
	public static String[] carrito = new String[50];
	public static double[] preciosCarrito = new double[50];
	public static int cantidadProductos = 0;
	
	public static void anadirProducto(int categoria, int opcionProducto) {
		if (cantidadProductos < carrito.length) {

			carrito[cantidadProductos] = Menu.productos[categoria][opcionProducto];

			preciosCarrito[cantidadProductos] = Menu.precios[categoria][opcionProducto];

			cantidadProductos++;
		} else {
		        System.out.println("El carrito está lleno");
		}
		
		
	}
	
	public static void mostrarProductosSeleccionados() {
	    System.out.println("\n--- PRODUCTOS SELECCIONADOS ---");

	    if (cantidadProductos == 0) {
	        System.out.println("Todavía no has seleccionado ningún producto.");
	    } else {
	        for (int i = 0; i < cantidadProductos; i++) {
	            System.out.println((i + 1) + ". " + carrito[i]
	                    + " - " + preciosCarrito[i] + " €");
	        }
	    }
	}


	
	
	
	
	
	
}
