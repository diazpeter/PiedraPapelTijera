package piedraPapelOTijera;

import java.util.ArrayList;

public class Game {
	private ArrayList<Player> players;
	private int[] scores;

	public Game() {
		this.players = createPlayersList();
		this.scores = resetScores();
	}

	private ArrayList<Player> createPlayersList() {
		ArrayList<Player> players = new ArrayList<>();
		int choice;
		boolean minListSize = false;

		do {
			System.out.println(Messages.SELECT_OPTION);
			choice = Rules.promptChoice(CreationOptions.toStringArray());
			if (choice < 3) {
				Player player = createNewPlayer(choice);
				players.add(player);
				System.out.println(player.getName() + " " + Messages.JOINED);
			} else {
				minListSize = Rules.validateMinListSize(players.size());
			}
		} while (!minListSize);
		return players;
	}

	private Player createNewPlayer(int choice) {
		Player player = null;
		switch (choice) {
		case 1:
			player = new Human();
			break;
		case 2:
			player = new Bot();
			break;
		}
		return player;
	}

	public void runGame() {
//se juegan enfrentamientos de 1vs1 entre todos los jugadores, el que acumula más victorias es el ganador(aunque haya perdido alguno ds los enfrentamientos)		
//los jugadores con el puntaje más alto juegan nuevas rondas hasta quedar uno solo, los perdedores son eliminados		
		while (!onePlayerRemaining()) {
			playRound();
			refreshPlayersList();
		}
		showWinner(players.get(0));

	}

	private boolean onePlayerRemaining() {
//devuelve TRUE cuando queda sólo un jugador en la lista, es decir, el ganador
		return (players.size() == 1);
	}

	private void playRound() {
		int first, second, result;
		presentRound();
		generatePlayersHand();
		scores = resetScores();
		
//se recorre dos veces la lista de jugadores para enfrentar a cada player(primer for) con todos los siguientes (segundo for)
//el formato de juego es: player1 vs: player2, 3, 4 ...; player2 vs: player 3, 4, ... 
//los jugadores no juegan con los anteriores de la lista, ya que de ese modo se repetirían enfrentamientos (ej player 1 vs player2 y luego player2 vs player1)
//en el primer for se usa < en vez de <= para que el último player de la lista nunca pueda ser "first", ya que no tiene a nadie contra quien jugar
		for (int x = 0; x < players.size() - 1; x++) {
			first = players.get(x).getHand().getId();
			for (int y = x + 1; y <= players.size()-1; y++) {
				second = players.get(y).getHand().getId();
				result = Rules.getResult(first, second);
				updateScores(x, y, result);
			}
		}
	}

	private void presentRound() {
		System.out.println(Messages.ROUND_PLAYERS);
		for (Player p : players) {
			System.out.println(p.getName());

		}
		System.out.println("\r");
	}

	private int[] resetScores() {
//cada vez que se juega una ronda se reinician los puntajes;
		int[] newScores = new int[players.size()];
		return newScores;
	}

	private void updateScores(int idPlayer1, int idPlayer2, int result) {
		switch (result) {
		case 1:
			scores[idPlayer1]++;
			break;
		case 2:
			scores[idPlayer2]++;
			break;
		}

	}

	private void generatePlayersHand() {
		for (Player p : players) {
			System.out.println(p.getName() + " " + Messages.SELECT_HAND);
			p.chooseHand();
			System.out.println(p.getName() + " " + Messages.HAND_SELECTED + " " + p.getHand().getElemento());
			System.out.println("\r");
		}

	}

	private void refreshPlayersList() {
// crea una copia de la lista de jugadores, obtiene al ganador/es y los guarda
// en la lista de players. Los perdedores dejan de existir...
		ArrayList<Player> refreshedList = new ArrayList<>();
		int maxScore = Integer.MIN_VALUE;
		for (int x = 0; x <= scores.length - 1; x++) {
			switch (compareScores(scores[x], maxScore)) {
			case 1:
				maxScore = scores[x];
				refreshedList.clear();
				refreshedList.add(players.get(x));
				break;
			case 0:
				refreshedList.add(players.get(x));
				break;

			}
		}

		players = refreshedList;
	}

	private int compareScores(int aScore, int maxScore) {
		int result;
		if (aScore > maxScore)
			result = 1;
		else if (aScore < maxScore)
			result = -1;
		else
			result = 0;
		return result;
	}

	private void showWinner(Player winner) {
		System.out.println(Messages.WINNER + winner.toString());

	}

}
