package hm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ID: TODO: please add student ID here (5 points)
 * Name: TODO: please add student name here (5 points)
 * Try to write some comments for your codes (methods, 15 points)
 * B0544242 葉明瑋 這是一個把卡片PRINT出來的程式..........
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank,
						checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/*
 * Description: TODO: please add description here 有 nDeck 副牌,進去跑 nDeck 次 ;有 4(x)
 * 個花色,進去跑 4(x) 次;有 13(y) 個rank,進去跑 13(y) 次; 每次new 一個 card,add進cards的ArrayList
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		for (int i = 1; i <= nDeck; i++) {
			for (int x = 1; x <= 4; x++) {
				for (int y = 1; y <= 13; y++) {
					Card card = new Card(x, y);
					cards.add(card);
				}
			}
		}
	}

	// TODO: Please implement the method to print all cards on screen (10
	// points)

	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5
		// points)
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/*
 * Description: TODO: please add description here 呼叫這個method可以把卡片print出來
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit,
	// 10 for rank)
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace
		
		switch (suit) {
		case 1:
			if (rank == 1) {
				System.out.println("Clubs " + "Ace");
				break;
			} else {
				System.out.println("Clubs " + rank);
				break;
			}
		case 2:
			if (rank == 1) {
				System.out.println("Diamonds " + "Ace");
				break;
			} else {
				System.out.println("Diamonds " + rank);
				break;
			}
		case 3:
			if (rank == 1) {
				System.out.println("Hearts " + "Ace");
				break;
			} else {
				System.out.println("Hearts " + rank);
				break;
			}
		case 4:
			if (rank == 1) {
				System.out.println("Spades " + "Ace");
				break;
			} else {
				System.out.println("Spades " + rank);
				break;
			}
		}

	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
