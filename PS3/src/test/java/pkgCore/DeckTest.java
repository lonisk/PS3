package pkgCore;
//import stuff
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void TestEmptyDeck() {
		Deck deck = new Deck();
		for (int i = 1; i <= 52; i++) {
			thrown.expect(IndexOutOfBoundsException.class);
			deck.Draw();
			System.out.println("card number " + i);
		}
	}
	
	@Test
	public void TestDrawSuit() {
		Deck deck = new Deck();
		for (int i = 1; i <= 13; i++) {
			assertEquals(deck.Draw(eSuit.CLUBS).geteSuit(), new Card(eSuit.CLUBS, eRank.THREE).geteSuit());
		}
	}
	
	@Test
	public void TestDrawRank() {
		Deck deck = new Deck();
		for (int i = 1; i <= 4; i++) {
			assertEquals(deck.Draw(eRank.THREE).geteRank(), new Card(eSuit.CLUBS, eRank.THREE).geteRank());
		}
	}
	
	@Test
	public void TestDeckRankCount() {
		Deck deck = new Deck();
		for (int i = 4; i > 0; i--) {
			assertEquals(deck.Count(eRank.THREE), i);
			deck.Draw(eRank.THREE);
		}
	}
	@Test
	public void TestDeckSuitCount() {
		Deck deck = new Deck();
		for (int i = 13; i > 0; i--) {
			assertEquals(deck.Count(eSuit.CLUBS), i);
			deck.Draw(eSuit.CLUBS);
		}
	}

}