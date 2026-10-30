package modelo;

public class Modelo {
	// Arrays bidimensionales
	// Representación visual:
	//       Col-0	 Col-1	 Col-2	 Col-3	  Col-4
	//Fila0 |  S  | |  M  | |  L  | |  XL  | |     |Cajas Sorpresa
	//      |10.00| |15.00| |25.00| |30.00 | |     |
	//      |_S00_| |_S01_| |_S02_| |_S03__| |_____|
	// 
	//Fila1 |Pollo| |Maris| |Cerdo| |Picant| |     |Ramen
	//      |5.00 | |4.50 | |5.00 | |5.00  | |     |
	//      |_R00_| |_R01_| |_R02_| |_R03__| |_____|
	//
	//Fila2 |Cafe | |Yoong| |Monst| |Naranj| |     |Bebidas
	//      |1.50 | |2.50 | |3.00 | |2.00  | |     |
	//      |_B00_| |_B01_| |_B02_| |_B03__| |_____|
	//
	//Fila3 |Orio | |Pocky| |Chicl| |Chips | |     |Snacks(Picoteo)
	//      |2.00 | |2.50 | |5.00 | |3.00  | |     |
	//      |_P00_| |_P01_| |_P02_| |_P03__| |_____|
	//
	public static String[][] productos = { 
			{ "S", "M", "L", "XL", "" },
			{ "Ramen pollo", "Ramen marisco", "Ramen cerdo", "Ramen picante", "" },
			{ "Cafe", "Soda Yoongi", "Monster Energy", "Soda naranja", "" },
			{ "Orio", "Pockys", "Chicles sabor BTS", "Patatas Chipstar", "" } 
		};

	public static double[][] precios = { 
			{ 10.00, 15.00, 25.00, 30.00, -1 }, 
			{ 5.00, 4.50, 5.00, 5.00, -1 },
			{ 1.50, 2.50, 3.00, 2.00, -1 }, 
			{ 2.00, 2.50, 5.00, 3.00, -1 } 
		};

	public static String[][] codigos = { 
			{"S00", "S01", "S02","S03", ""}, 
			{"R00", "R01", "R02","R03", ""}, 
			{"B00", "B01", "B02","B03", ""},
			{"P00", "P01", "P02","P03", ""}
		};
	
	public static int maxProductos = 5;
}
