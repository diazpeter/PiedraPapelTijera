package piedraPapelOTijera;

public enum Elemment {
PIEDRA, PAPEL, TIJERA;


public static String[] toStringArray() {
//Para obtener un array de Strings con los valores de Elemment, y así poder pasarselo a promptChoice()
	String[] stringArray= new String[values().length];
	for(int i = 0; i<=values().length-1; i++) {
		stringArray[i]=values()[i].toString();
	}
	return stringArray;
}
}
