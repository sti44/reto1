package controlador;

import java.util.Scanner;

public class Admin {

	private static Scanner sc = new Scanner(System.in);

	private static String userAdmin = "ñu";
	private static String claveAdmin = "creeper";

	// Comprobar el usuario:
	// Coincide el usuario: comprueba la clave y si se valida muestra el menú de
	// admin.
	// No coincide con el usuario: muestra los tipos de productos para el usuario
	// estándar
	public static void iniciaTipoUsuario() {

		Compra.vaciarCarrito();
		Menu.mostrarBienvenida();
		// Usuario Admin: ñu
		// Clave Admin: creeper
		String usuarioIntroducido = sc.nextLine();

		if (usuarioIntroducido.equalsIgnoreCase(Admin.userAdmin)) {
			// Validar si la clave de Admin es correcta.
			boolean admin = validarClave();
			if (admin) {
				opcionesAdmin();
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
			System.out.println("Contraseña Incorrecta. Volviendo al Inicio...");
			System.out.println();
			adminValidado = false;
		}
		return adminValidado;
	}

	// El menú de opciones se repite hasta que se elija la opción 4
	// Cuando las acciones del switch terminan se vuelve al bucle
	public static void opcionesAdmin() {

		int opcion = -1;

		while (opcion != 4) {
			Menu.mostrarMenuAdmin();

			opcion = accionValidaAdmin(opcion);

			switch (opcion) {
			case 1:
				System.out.println("Añadir Nuevo Producto Seleccionado");
				nuevoProducto();
				break;
			case 2:
				System.out.println("Modificar Producto Seleccionado");
				modificarProducto();
				break;
			case 3:
				System.out.println("Eliminar Producto Seleccionado");
				eliminarProducto();
				break;
			case 4:
				if (salirModoAdmin()) {
					opcion = 4;
				} else {
					opcion = -1;
				}
				break;
			default:
				System.out.println("Número seleccionado incorrecto");
				break;
			}
		}
	}

	// Valida si la acción de Admin introducida es un número que se encuentra entre
	// las opciones ofrecidas.
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

	// Valida si la modificación de Admin introducida es un número que se encuentra
	// entre las opciones ofrecidas.
	public static int modificarOpcionValidaAdmin() {
		boolean opcionValida = false;
		int opcion = -1;
		do {
			Menu.menuModificarProducto();
			// Validación de que el valor introducido es correcto
			try {
				opcion = Integer.valueOf(sc.nextLine());

				if (opcion >= 1 && opcion <= 4) {
					opcionValida = true;
				} else {
					System.out.println("Opción no válida. Selecciona del 1 al 4, por favor. ");
					opcionValida = false;
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduce un número valido.");
			}
		} while (!opcionValida);
		return opcion;
	}

	// Validación para salir del Modo Admin. Vuelve al menú de Bienvenida del
	// inicio.
	public static boolean salirModoAdmin() {
		System.out.println("¿Desea salir del Modo Empleado? \n Salir \n Continuar");
		String respuesta = sc.nextLine().trim().toUpperCase();

		if (respuesta.equalsIgnoreCase("salir")) {
			iniciaTipoUsuario();
			return true;
		} else if (respuesta.equalsIgnoreCase("continuar")) {
			System.out.println("¡Continuamos en el Modo Empleado!");
			return false;
		} else {
			System.out.println("Opción no válida, escriba salir o continuar, por favor.");
			return false;
		}

	}

	// Validación para salir de una acción de Admin. Vuelve al menú del Admin.
	public static boolean salirOpcionAdmin() {
		String respuesta = "";
		boolean salir = false;
		do {
			System.out.println("¿Desea volver al menú o continuar? \n Volver. \n Continuar.");
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

	// Valida si el tipo de producto es un número que se encuentra entre las
	// opciones ofrecidas.
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
					valido = true;
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

	// Método con las opciones para añadir productos
	public static void nuevoProducto() {
		int tipoProductoElegido = validaTipoDeProductoAdmin();

		if (tipoProductoElegido == 0) {
			return;
		}

		int indexTipoProductoElegido = tipoProductoElegido - 1;

		if (comprobarHuecosProducto(indexTipoProductoElegido) == -1) {
			opcionesAdmin();
			return;
		}

		switch (tipoProductoElegido) {

		case 1:

		case 2:

		case 3:

		case 4:
			listaProductosActuales(indexTipoProductoElegido);
			añadirProducto(indexTipoProductoElegido);
			break;

		default:
			System.out.println("Seleccione un tipo de producto válido, por favor.");
			break;
		}

	}

	// Método para añadir un producto nuevo con nombre, precio y código
	public static void añadirProducto(int indexTipoProductoElegido) {
		int indice = modelo.Modelo.maxProductos - 1;

		String nombre = validarNombre();
		modelo.Modelo.productos[indexTipoProductoElegido][indice] = nombre;

		double precio = validarPrecio();
		modelo.Modelo.precios[indexTipoProductoElegido][indice] = precio;

		String codigo = validarCodigo(-1, -1);
		modelo.Modelo.codigos[indexTipoProductoElegido][indice] = codigo;

		System.out.println();
		System.out.println("Nombre de producto añadido: " + nombre);
		System.out.printf("Precio de producto añadido: %.2f €%n", precio);
		System.out.println("Código de producto añadido: " + codigo);

	}

	// Método para modificar un producto: nombre, precio o código
	public static void modificarProducto() {
		int tipoProductoElegido = validaTipoDeProductoAdmin();

		if (tipoProductoElegido == 0) {
			return;
		}

		int indexTipoProductoElegido = tipoProductoElegido - 1;
		int indexProducto = validaProductoElegido(indexTipoProductoElegido);

		if (indexProducto == -1) {
			return;
		}

		int opcionModificar = modificarOpcionValidaAdmin();

		switch (opcionModificar) {
		case 1:
			String nuevoNombre = validarNombre();
			modelo.Modelo.productos[indexTipoProductoElegido][indexProducto] = nuevoNombre;
			System.out.println("Nombre modificado correctamente.");
			System.out.println();
			listaProductosActuales(indexTipoProductoElegido);
			break;
		case 2:
			double nuevoPrecio = validarPrecio();
			modelo.Modelo.precios[indexTipoProductoElegido][indexProducto] = nuevoPrecio;
			System.out.println("Precio modificado correctamente.");
			System.out.println();
			listaProductosActuales(indexTipoProductoElegido);
			break;
		case 3:
			String nuevoCodigo = validarCodigo(indexTipoProductoElegido, indexProducto);
			modelo.Modelo.codigos[indexTipoProductoElegido][indexProducto] = nuevoCodigo;
			System.out.println("Código modificado correctamente.");
			System.out.println();
			listaProductosActuales(indexTipoProductoElegido);
			break;
		case 4:
			break;
		}
	}

	// Método para eliminar un producto.
	public static void eliminarProducto() {
		int tipoProductoElegido = validaTipoDeProductoAdmin();

		if (tipoProductoElegido == 0) {
			return;
		}

		int indexTipoProductoElegido = tipoProductoElegido - 1;
		int indexProducto = validaProductoElegido(indexTipoProductoElegido);

		if (indexProducto == -1) {
			return;
		}

		System.out.println("¿Está seguro de que desea eliminar este producto? \n S para eliminar \n N para mantener)");
		String respuesta = sc.nextLine().trim();

		if (respuesta.equalsIgnoreCase("S")) {
			desplazarProducto(indexTipoProductoElegido, indexProducto);
			System.out.println("Producto eliminado correctamente.");
		} else {
			System.out.println("Eliminación cancelada.");
		}
		listaProductosActuales(indexTipoProductoElegido);
	}

	// Método para desplazar los productos del array hacia la posición de su
	// izquierda
	// y eliminar el dato duplicado que queda en la última posición.
	public static void desplazarProducto(int indexTipoProductoElegido, int indexProducto) {
		// Desplazar productos
		for (int i = indexProducto; i < modelo.Modelo.maxProductos - 1; i++) {

			modelo.Modelo.productos[indexTipoProductoElegido][i] = modelo.Modelo.productos[indexTipoProductoElegido][i
					+ 1];

			modelo.Modelo.precios[indexTipoProductoElegido][i] = modelo.Modelo.precios[indexTipoProductoElegido][i + 1];

			modelo.Modelo.codigos[indexTipoProductoElegido][i] = modelo.Modelo.codigos[indexTipoProductoElegido][i + 1];
		}

		// Eliminar última posición
		int ultimaPosicion = modelo.Modelo.maxProductos - 1;
		modelo.Modelo.productos[indexTipoProductoElegido][ultimaPosicion] = "";
		modelo.Modelo.precios[indexTipoProductoElegido][ultimaPosicion] = -1;
		modelo.Modelo.codigos[indexTipoProductoElegido][ultimaPosicion] = "";
	}

	// Valida el producto a modificar
	// Devuelve el index donde se encuentra el producto a modificar.
	public static int validaProductoElegido(int indexTipoProductoElegido) {
		int opcion = -1;
		boolean opcionValida = false;

		do {
			listaProductosActuales(indexTipoProductoElegido);

			System.out.println("\nSeleccione el número del producto:");

			try {
				opcion = Integer.parseInt(sc.nextLine());

				if (opcion == 0) {
					return -1;

				} else if (opcion >= 1 && opcion <= modelo.Modelo.productos[indexTipoProductoElegido].length
						&& !modelo.Modelo.productos[indexTipoProductoElegido][opcion - 1].isEmpty()) {
					opcionValida = true;

				} else {
					System.out.println("Seleccione un producto existente, por favor.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Introduzca un número válido.");
			}

		} while (!opcionValida);

		return opcion - 1;
	}

	// Valida que el nombre no se haya introducido vacío o con espacios.
	public static String validarNombre() {
		boolean nombreValido = false;
		String nombre = "";
		do {
			System.out.println("Introduzca el nombre del nuevo producto:");
			nombre = sc.nextLine().trim();
			if (nombre.trim().isEmpty()) {
				System.out.println("El nombre no puede estar vacío, introduzca un nombre válido, por favor.");
			} else {
				nombreValido = true;
			}
		} while (!nombreValido);
		return nombre;
	}

	// Valida que el precio sea un número mayor de 0.
	public static double validarPrecio() {
		double precio = 0;
		boolean precioValido = false;

		do {
			try {
				System.out.println("Introduzca el precio del nuevo producto:");
				precio = Double.parseDouble(sc.nextLine());
				if (precio > 0) {
					precioValido = true;
				} else {
					System.out.println("El precio debe ser mayor que 0.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Introduce un número valido.");
			}
		} while (!precioValido);
		return precio;
	}

	// Valida que no se introduzca un código vacío y que no esté repetido.
	public static String validarCodigo(int indexTipoProductoElegido, int indexProducto) {
		boolean codigoValido = false;
		String codigo = "";
		do {
			System.out.println("Introduzca el código del nuevo producto:");
			codigo = sc.nextLine().trim();

			if (codigo.isEmpty()) {
				System.out.println("El código no puede estar vacío, introduzca un código válido, por favor.");
			} else {
				boolean codigoExiste = false;

				for (int fila = 0; fila < modelo.Modelo.codigos.length; fila++) {
					for (int col = 0; col < modelo.Modelo.codigos[fila].length; col++) {
						if (!modelo.Modelo.codigos[fila][col].isEmpty()
								&& modelo.Modelo.codigos[fila][col].equalsIgnoreCase(codigo)
								&& (fila != indexTipoProductoElegido || col != indexProducto)) {
							codigoExiste = true;
						}
					}
				}

				if (codigoExiste) {
					System.out.println("Ya tenemos ese código. Elija otro, por favor.");
				} else {
					codigoValido = true;
				}
			}
		} while (!codigoValido);
		return codigo;
	}

	// Comprueba si hay huecos en el array de productos:
	// Hay hueco: pregunta si quiere continuar o salir.
	// No hay hueco: vuelve al menú de Admin
	public static int comprobarHuecosProducto(int tipoProductoElegido) {

		int resultado = -1;

		if (modelo.Modelo.productos[tipoProductoElegido][modelo.Modelo.maxProductos - 1].equalsIgnoreCase("")) {
			resultado = tipoProductoElegido;
			listaProductosActuales(tipoProductoElegido);
			System.out.println("\n Tenemos hueco para un nuevo producto.\n");
			if (salirOpcionAdmin()) {
				return -1;
			}
		} else {
			listaProductosActuales(tipoProductoElegido);
			System.out.println("\n No tenemos hueco para un nuevo producto.\n");
			return -1;
		}
		return resultado;
	}

	// Mostrar la lista de los productos que tenemos actualmente
	public static void listaProductosActuales(int indexTipoProductoElegido) {
		System.out.println();
		System.out.println("Lista de productos actuales: ");
		System.out.println();

		for (int i = 0; i < modelo.Modelo.productos[indexTipoProductoElegido].length; i++) {

			if (!modelo.Modelo.productos[indexTipoProductoElegido][i].isEmpty()) {

				System.out.printf("%d. %-8s %-20s %.2f €%n", (i + 1),
						modelo.Modelo.codigos[indexTipoProductoElegido][i],
						modelo.Modelo.productos[indexTipoProductoElegido][i],
						modelo.Modelo.precios[indexTipoProductoElegido][i]);
			}
		}

		System.out.println();
		System.out.println("0. Volver al menú de administración");
	}

}
