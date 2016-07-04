package com.vurb.deckImplementationClasses;

import java.util.ArrayList;

public class DeckWithCards {
	
	private int id;
	private String description;
	ArrayList<Cards> cards;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Cards> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Cards> cards) {
		this.cards = cards;
	}
	
}
