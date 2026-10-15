package modelo;

import controlador.Menu;

public class Main {

	public static void main(String[] args) {
		Menu.mostrarBienvenida();
        
        int opcion;
       
        do { 
            opcion = Menu.mostrarTipoProductos();
            Menu.opcionTipoProductos(opcion);
            
        } while (opcion != 5);
        
        System.out.println("¡Gracias por usar Elorrieta Vending! ¡Hasta pronto!");
    }	
}


