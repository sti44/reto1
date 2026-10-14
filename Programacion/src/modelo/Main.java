package modelo;

import controlador.Menu;

public class Main {

	public static void main(String[] args) {
		Menu.mostrarBienvenida();
		while(true) {
			int seleccion = Menu.mostrarTipoProductos();
			Menu.opcionTipoProductos(seleccion);
		}
	}

}
