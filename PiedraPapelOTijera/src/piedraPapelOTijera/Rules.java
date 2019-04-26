package piedraPapelOTijera;

import java.util.Scanner;

public abstract class Rules implements Messages {
//Clase abstracta con la lógica del juego y las reglas de validación de los ingresos por teclado
//algunos de sus métodos y atributos son estáticos para poder accederlos desde otras clases sin necesidad de intanciación	
	
	public static Scanner input = new Scanner(System.in);
	private static final int MIN_CHOICE= 1;
	private static final int MAX_CHOICE= 3;
	private static final int MIN_LIST_SIZE=2;
	private static final int P1_WINS=1;
	private static final int P2_WINS=2;
	private static final int TIE=0;
	
	
//matriz de resultados
	private static int[][] rulesGrid = generateGrid();
	private static int[][] generateGrid() {
		int[][] rulesGrid = new int[3][3];
		rulesGrid[0][0] = TIE;
		rulesGrid[0][1] = P2_WINS;
		rulesGrid[0][2] = P1_WINS;
		rulesGrid[1][0] = P1_WINS;
		rulesGrid[1][1] = TIE;
		rulesGrid[1][2] = P2_WINS;
		rulesGrid[2][0] = P2_WINS;
		rulesGrid[2][1] = P1_WINS;
		rulesGrid[2][2] = TIE;
		return rulesGrid;
	}

	
	public static int promptChoice(String[] values) {
//Recibe como parámetro un array de Strings con las opciones(pueden ser las opciones de creación o de selección de jugada)		
		int choice;
		for (int i = 0; i < values.length; i++) {
			System.out.print((i+1) + "-" + values[i] + " ");
		}
		
		choice = validateChoice(getInt());
		return choice;
	}

	private static int getInt() {
//para asegurarse de que se ingrese un numero entero, en caso contrario devuelve un valor(entero) incorrecto para activar error de validación		
		int aInt=Integer.MAX_VALUE;
		if (input.hasNextInt()) {
			aInt=input.nextInt();
	    }
		input.nextLine();
		return aInt;
	}


	public static int validateChoice(int choice) {
		while (choice < MIN_CHOICE || choice > MAX_CHOICE) {
			System.out.println(Messages.WRONG_CHOICE);
			System.out.println(Messages.INPUT_AGAIN);
			choice = getInt();		
		}

		return choice;
	}

	public static int getResult(int a, int b) {
//busca el resultado en la matriz de resultados usando como índice la jugada de cada player
		return rulesGrid[a][b];
	}


	public static boolean validateMinListSize(int listSize) {
		boolean result = false;
		
		if(listSize>=MIN_LIST_SIZE) {
			result = true;
		} else {
		System.out.println(Messages.NOT_MIN_SIZE);
		System.out.println(Messages.INPUT_AGAIN);
		}
		return result;
	}



}
