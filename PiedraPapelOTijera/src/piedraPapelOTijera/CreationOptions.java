package piedraPapelOTijera;

public enum CreationOptions {
CREAR_JUGADOR,
CREAR_BOT, 
COMENZAR_PARTIDA,
;


public static String[] toStringArray() {
//Para obtener un array de Strings con los valores de CreationOptions, y así poder pasarselo a promptChoice()
	String[] stringArray= new String[values().length];
	for(int i = 0; i<=values().length-1; i++) {
		stringArray[i]=values()[i].toString();
	}
	return stringArray;
}

}

