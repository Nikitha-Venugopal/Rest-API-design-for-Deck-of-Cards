package com.vurb.deckImplementationClasses;

import java.util.ArrayList;

public class CombinedResponse {
	
	private ArrayList<DeckWithCards> decks;
	private int nextPageToken;
	private int resultSizeEstimate;
	
	public ArrayList<DeckWithCards> getDecks() {
		return decks;
	}
	public void setDecks(ArrayList<DeckWithCards> decks) {
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
