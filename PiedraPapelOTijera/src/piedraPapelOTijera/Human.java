package piedraPapelOTijera;


public class Human extends Player {

	public Human(String name) {
		super(name);
	}
	
	public Human() {
		this(inputName());
	}

	@Override
	public void chooseHand() {
		Elemment elemment;
		int choice;
		choice = Rules.promptChoice(Elemment.toStringArray())-1;
		elemment = Elemment.values()[choice];
		setHand(elemment, choice);

	}

}
