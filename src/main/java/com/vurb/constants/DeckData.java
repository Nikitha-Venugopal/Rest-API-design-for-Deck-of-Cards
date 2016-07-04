package com.vurb.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vurb.deckImplementationClasses.Cards;
import com.vurb.deckImplementationClasses.DeckWithCards;
import com.vurb.deckImplementationClasses.DeckWithoutCards;
import com.vurb.deckImplementationClasses.Payload;

@Service
@Scope("singleton")
public class DeckData {
	private  static ArrayList<Cards> cardList = new ArrayList<Cards>();
	private  static ArrayList<DeckWithoutCards> deckwithoutCardsList = new ArrayList<DeckWithoutCards>();
	private  static HashMap<Integer,DeckWithCards> deckWithCards = new LinkedHashMap<Integer,DeckWithCards>();;
	
	
	public ArrayList<Cards> getCardDictionary() {
		return cardList;
	}

	public void setCardDictionary(ArrayList<Cards> cardList) {
		this.cardList = cardList;
	}

	public ArrayList<DeckWithoutCards> getDeckwithoutCardsList() {
		return deckwithoutCardsList;
	}

	public void setDeckwithoutCardsList(
			ArrayList<DeckWithoutCards> deckwithoutCardsList) {
		this.deckwithoutCardsList = deckwithoutCardsList;
	}

	public HashMap<Integer,DeckWithCards> getDeckWithCards() {
		return deckWithCards;
	}

	public void setDeckWithCards(HashMap<Integer,DeckWithCards> deckWithCards) {
		this.deckWithCards = deckWithCards;
	}

	//The following function populates the Cards class with the generated values and creates a array list of cards
	public void addCardsData(){	
		//Considering each deck has random number of cards between 1 to 11;
		int range = randInt(1,11);
		
		Cards dummyCard = new Cards();
		dummyCard.setId(0);
		dummyCard.setTitle("");
		Payload dummyPayload = new Payload("");
		dummyCard.setPayload(dummyPayload);
		cardList.add(dummyCard);
		
		for(int i=1; i<=range; i++){			
			Cards card = new Cards();
			card.setId(i);
			card.setTitle("card " + i);
			Payload payload = new Payload("payload "+ i);
			card.setPayload(payload);
			cardList.add(card);
		}		
	}
	
	//The following function builds a list of deck data which just has the Id and description
	public void addDecksWithoutCards(){	
		
		DeckWithoutCards dwcardsDummy = new DeckWithoutCards();
		dwcardsDummy.setId(0);
		dwcardsDummy.setDescription("");
		deckwithoutCardsList.add(dwcardsDummy);
		
		for(int i=1; i<=10; i++){
			DeckWithoutCards dwcards = new DeckWithoutCards();
			dwcards.setId(i);
			dwcards.setDescription("description "+ i);
			deckwithoutCardsList.add(dwcards);
		}
	}
	
	//The following function generates a map with all the card data as well as the deck data.
	//This map can be used to get the deck data when id is given as input
	public void addDecksWithCards(){	
		this.addCardsData();
		for(int i=1; i<deckwithoutCardsList.size(); i++){
			DeckWithCards dWithCards = new DeckWithCards();
			dWithCards.setCards(cardList);
			dWithCards.setId(deckwithoutCardsList.get(i).getId());
			dWithCards.setDescription(deckwithoutCardsList.get(i).getDescription());
			deckWithCards.put(i, dWithCards);
		}
	}
		
	public void buildDeckData(){
		//this.addCardsData();
		this.addDecksWithoutCards();
		this.addDecksWithCards();
	}
	
	public  int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
