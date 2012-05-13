package com.ovrevik.deckofcards;

import java.util.Random;

public class CardDeck {
	private static final int CARD_COUNT = 52; //the card count was fixed in the problem description
	private final Random random = new Random();
	//the deck maintains permanent ownership of all it's cards even though they might be dealt out.
	//The cards may be in someone's hand but they still belong to the deck.
	private final Card[] cards = new Card[52];
	private final Card[] toDeal = new Card[52];
	private int dealIndex;
	
	//instance initializer
	{
		//all card indexes and counts could be bytes but, that seems a little excessive.
		int cardIndex = 0;
		for (CardSuite suite : CardSuite.values()) {
			for (CardRank rank : CardRank.values()) {
				cards[cardIndex++] = new Card(rank, suite);
			}			
		}
	}
	
	public CardDeck() {
		//it seems reasonable that the client would normally want the deck shuffled upon instantiation
		this(true);
	}

	public CardDeck(boolean shuffle) {
		initialize(shuffle);
	}
	
	/* From a modeling perspective, the shuffle and deal_one_card methods should be in a class like
	 * Dealer since decks don't physically shuffle themselves. But this would require exposing the
	 * card array and it's easy to get into a class sprawl situation.
	 */
	
	/**
	 * Shuffle the cards that are left to deal.
	 */
	synchronized public void shuffle() {
		System.out.println(String.format("shuffling with dealIndex: %d", dealIndex));
		//iterate from the deal index through the highest index - 1 (count - 2)
		for (int i = dealIndex; i < CARD_COUNT - 1; i++) {
			int j = i + random.nextInt(CARD_COUNT - 1 - i) + 1;
			System.out.println(String.format("swap %d with %d, (1-%d]", i, j, CARD_COUNT - 1 - i));
			//swap i with random remaining index
			Card temp = toDeal[i];
			toDeal[i] = toDeal[j];
			toDeal[j] = temp;
		}
	}
	
	/**
	 * Retrieve the next card from the deal deck.
	 * @return the next card if one exists, null otherwise
	 */
	synchronized public Card deal_one_card()  {
		return dealIndex < CARD_COUNT ? toDeal[dealIndex++] : null;
	}
	
	public void initialize() {
		//again... it seems reasonable that the client would normally want the deck shuffled
		initialize(true);
	}
	
	synchronized public void initialize(boolean shuffle) {
		System.arraycopy(cards, 0, toDeal, 0, CARD_COUNT);
		dealIndex = 0;
		if (shuffle) {
			shuffle();
		}
	}

	public int getDealtCount() {
		return dealIndex;
	}
	
	public int getRemainingCount() {
		return CARD_COUNT - getDealtCount();
	}

	public static void main(String[] args) {		
		Card card;
		CardDeck deck;
		
		//typical scenario
		deck = new CardDeck();
		for (int i = 1; i <= CARD_COUNT; i++ ) {
			card = deck.deal_one_card();
			assert card != null;
		}
		card = deck.deal_one_card();
		assert card == null;

		//verify that shuffle can be called after cards have been dealt.
		//shuffle after every deal
		deck = new CardDeck();
		for (int i = 1; i <= CARD_COUNT; i++ ) {
			card = deck.deal_one_card();
			assert card != null;
			deck.shuffle();
		}
		card = deck.deal_one_card();
		assert card == null;

		//you should be be able to deal out of a new deck without shuffling
		deck = new CardDeck(false);
		for (int i = 1; i <= CARD_COUNT; i++ ) {
			card = deck.deal_one_card();
			assert card != null;
		}
		card = deck.deal_one_card();
		assert card == null;
	}
}
