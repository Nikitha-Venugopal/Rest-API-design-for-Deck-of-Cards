package com.vurb.deckImplementationClasses;

import java.util.ArrayList;

public class Deck {
	
	ArrayList<Decks> decks;
	int nextPageToken;
	int resultSizeEstimate;
	
	public Deck(ArrayList<Decks> decks, int nextPageToken, int resultSizeEstimate){
		this.decks = decks;
		this.nextPageToken = nextPageToken;
		this.resultSizeEstimate = resultSizeEstimate;
	}
	public ArrayList<Decks> getDecks() {
		return decks;
	}
	public void setDecks(ArrayList<Decks> decks) {
		this.decks = decks;
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
