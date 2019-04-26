package piedraPapelOTijera;

public abstract class Player {
	private String name;
	private Hand hand;

	public Player(String name) {
		super();
		this.name = name;

	}

	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Elemment elemment, int choice) {
		this.hand = createHand(elemment, choice);
	}

	public abstract void chooseHand();

	private Hand createHand(Elemment elemento, int id) {

		Hand hand = new Hand(elemento, id);
		return hand;
	}

	@Override
	public String toString() {
		return (name + " con " + hand.getElemento());
	}
	
	public static String inputName() {
		String name;
		System.out.println(Messages.INPUT_NAME);
		name = Rules.input.nextLine();
		return name;
	}

}
