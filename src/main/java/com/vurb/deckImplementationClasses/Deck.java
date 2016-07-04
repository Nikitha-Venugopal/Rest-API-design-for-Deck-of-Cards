package com.vurb.deckImplementationClasses;

import java.util.ArrayList;

public class Deck {
	
	ArrayList<DeckWithoutCards> deckWithoutCards;
	int nextPageToken;
	int resultSizeEstimate;
	
	public Deck(ArrayList<DeckWithoutCards> deckWithoutCards, int nextPageToken, int resultSizeEstimate){
		this.deckWithoutCards = deckWithoutCards;
		this.nextPageToken = nextPageToken;
		this.resultSizeEstimate = resultSizeEstimate;
	}
	public ArrayList<DeckWithoutCards> getDeckWithoutCards() {
		return deckWithoutCards;
	}
	public void setDeckWithoutCards(ArrayList<DeckWithoutCards> deckWithoutCards) {
		this.deckWithoutCards = deckWithoutCards;
	}
	public int getNextPageToken() {
		return nextPageToken;
	}
	public void setNextPageToken(int nextPageToken) {
		this.nextPageToken = nextPageToken;
	}
	public int getResultSizeEstimate() {
		return resultSizeEstimate;
	}
	public void setResultSizeEstimate(int resultSizeEstimate) {
		this.resultSizeEstimate = resultSizeEstimate;
	}
}
