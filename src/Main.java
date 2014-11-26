import java.util.ArrayList;
import java.util.Collections;

public class Main {

	private final int JOKERS = 1;
	private final int BLACKS = 26;
	private final int REDS = 26;

	private final int STAKE = 100;
	private final int WIN = 200;

	private final int CARDS = JOKERS + BLACKS + REDS;

	private final int RED = 0;
	private final int BLACK = 1;
	private final int JOKER = 2;

	private int wins = 0;
	private int losses = 0;

	private final int GAMES = 100000;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {

		// ArrayList<Integer> arr = initGame();

		for (int i = 0; i < GAMES; i++) {
			playGame(initGame());
		}
		finishGames();
	}

	private void playGame(ArrayList<Integer> cards) {

		int reds = REDS;
		int blacks = BLACKS;
		int jokers = JOKERS;

		for (int i = 0; i < CARDS; i++) {
			int card = cards.get(i);

			// make a qualified guess here, or force guess if last card
			if (reds - blacks > 2 || i == CARDS-1) {
				if (card == RED) {
					wins++;
				} else {
					losses++;
				}
				break;
			}

			switch (card) {
				case RED:
					reds--;
					break;
				case BLACK:
					blacks--;
					break;
				case JOKER:
					jokers--;
					break;
				default:
					break;

			}

		}
	}

	private void finishGames() {
		int lostAmount = (wins + losses) * STAKE;
		int wonAmount = wins * WIN;

		System.out.println("Wins: " + wins);
		System.out.println("Losses: " + losses);
		System.out.println("Money at finish: " + (wonAmount - lostAmount));
	}

	private ArrayList<Integer> initGame() {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < JOKERS; i++) {
			arr.add(JOKER);
		}
		for (int i = 0; i < BLACKS; i++) {
			arr.add(BLACK);
		}
		for (int i = 0; i < REDS; i++) {
			arr.add(RED);
		}

		Collections.shuffle(arr);

		return arr;
	}
}
