import java.util.Arrays;
import java.util.Collections;

public class mainActivity {

//	public static String[] suits = { "Hearts", "Clubs", "Spades", "Diamonds" };
	public static String[] suits = { "\u2764Hearts", "\u2663Clubs", "\u2660Spades", "\u2666Diamonds" };
	
	public static String[] cardValues = { "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "J", "Q", "K", "A" };
	public static String[] deck = new String[52];

	public static int tableSize = 6;

	public static void main(String[] args) {
		initialize();
		breakLine();
		System.out.println("\tTexas Hold'em dealer for " + tableSize + " players");
		//showDeck();
		breakLine();
		dealPlayers();
		breakLine();
		dealFlop();
		dealTurn();
		dealRiver();
		breakLine();
	}

	private static void breakLine() {
		System.out.println();
	}

	private static void dealRiver() {
		int riverCard = (tableSize*2) + 7;
		System.out.println("\tRiver: \t\t" + deck[riverCard]);

	}

	private static void dealTurn() {
		int turnCard = (tableSize*2) + 5;
		System.out.println("\tTurn: \t\t" + deck[turnCard]);
	}

	public static void createDeck() {
		int cardNo = 0;
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < cardValues.length; j++) {
				deck[cardNo++] = suits[i].charAt(0) + cardValues[j];
			}
		}
	}

	private static void dealPlayers() {
		System.out.println();
		int playerNo = 1;
		for (int i = 0; i < deck.length; i++) {
			String card1 = deck[i];
			String card2 = deck[i+1];
			String player = "\tPlayer " + playerNo;
			System.out.println(player + "\t" + card1 + "\t" + card2);
			i++;
			if(playerNo++ == tableSize) break;
		}
	}
	
	private static void initialize() {
		createDeck();
		shuffleDeck();
	}
	
	private static void dealFlop() {
		int flopCards = tableSize*2;
		System.out.println("\tFlop:" + "\t\t" + deck[flopCards+1] + "\t" + deck[flopCards+2] + "\t" + deck[flopCards+3]);
	}

	public static void shuffleDeck() {
		Collections.shuffle(Arrays.asList(deck));
	}

	@SuppressWarnings("unused")
	private static void showDeck() {
		System.out.println();
		for (int i = 0; i < deck.length; i++) {
			System.out.print(i < deck.length - 1 ? deck[i] + "," : deck[i]);
		}
	}
}
