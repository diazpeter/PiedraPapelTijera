package piedraPapelOTijera;

public class Hand {

	private Elemment elemment;
	private int id;

	public Hand() {
	}

	public Hand(Elemment elemento, int id) {
		super();
		this.elemment = elemento;
		this.id = id;
	}

	public Elemment getElemento() {
		return elemment;
	}

	public void setElemento(Elemment elemento) {
		this.elemment = elemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
