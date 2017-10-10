package pkgCore;
//import stuff
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() {
		// draw card from deck
		try {
			return cardsInDeck.remove(0);
		} catch (Exception EXCEPT) {

			System.out.println("Deck out of Cards");
			throw EXCEPT;
		}
	}

	public Card Draw(eSuit eSuit) {
		for (Card card: this.cardsInDeck) {
			if (card.geteSuit() == eSuit) {
				cardsInDeck.remove(card);
				return card;
			}
		}
		return null;
	}

	public Card Draw(eRank eRank) {
		for (Card card: this.cardsInDeck) {
			if (card.geteRank() == eRank) {
				cardsInDeck.remove(card);
				return card;
			}
		}
		return null;
	}

	public int Count(eSuit eSuit) {
		ArrayList<Card> SuitCards = cardsInDeck.stream().filter(type -> type.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));
		return SuitCards.size();

	}

	public int Count(eRank eRank) {
		ArrayList<Card> RankCards = cardsInDeck.stream().filter(type -> type.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));
		return RankCards.size();

	}

	public int FindCard(Card c) {
		for (Card cards:cardsInDeck)
		{
			if (cards == c)
				return 1;
		}
		return 0;
	}
}