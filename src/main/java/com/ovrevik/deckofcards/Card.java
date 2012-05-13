package com.ovrevik.deckofcards;

/**
 * Immutable class.
 * @author ryanovrevik
 */

public class Card {
	final CardRank rank;
	final CardSuite suite;
	
	public Card(CardRank rank, CardSuite suite) {
		this.rank = rank;
		this.suite = suite;
	}
}
