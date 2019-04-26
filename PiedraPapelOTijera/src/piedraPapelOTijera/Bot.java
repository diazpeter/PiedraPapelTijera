package piedraPapelOTijera;

public class Bot extends Player {

	public Bot(String aName) {
		super("BOT_" + aName);
	}
	
	public Bot() {
		this(inputName().toUpperCase());
	}

	@Override
	public void chooseHand() {
		int choice;
		Elemment elemment;
		choice = (int) (Math.random() * Elemment.values().length);
		elemment = Elemment.values()[choice];
		setHand(elemment, choice);

	}

}
