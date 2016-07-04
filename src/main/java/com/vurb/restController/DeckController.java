package com.vurb.restController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vurb.constants.DeckData;
import com.vurb.deckImplementationClasses.CombinedResponse;
import com.vurb.deckImplementationClasses.Deck;
import com.vurb.deckImplementationClasses.DeckWithCards;
import com.vurb.deckImplementationClasses.DeckWithoutCards;

@RestController
public class DeckController {
	
	@Autowired
	DeckData deckConstants;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	private String getUserId(HttpServletRequest request) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("data", "Hi I am from this application");
		
		return json.toString();
	
	}
	
	@RequestMapping(value="/users/user1/decks", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	private String getAllDeckData(HttpServletRequest request) throws JsonProcessingException{
		ArrayList<DeckWithoutCards> deckDetails = new ArrayList<DeckWithoutCards>();
		for(int i=0 ;i<10; i++){
			deckDetails.add(i,deckConstants.getDeckwithoutCardsList().get(i));
		}
		
		int totalResults = deckConstants.getDeckwithoutCardsList().size();
		int nextPageToken = 2; // The next page result is set as 2 always for this service.
		
		Deck deck = new Deck(deckDetails,nextPageToken,totalResults);
		
		
		ObjectMapper obj = new ObjectMapper();
		String result = obj.writeValueAsString(deck);
		return result;
	}
	
	@RequestMapping(value="/users/user1/decks/{pgNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	private String getPaginatedDeckData(@PathVariable int pgNo,HttpServletRequest request) throws JsonProcessingException{
		//Check if the given page number is within the range of the pages divided		
		if(pgNo > Math.ceil(deckConstants.getDeckwithoutCardsList().size()/10.0)){
			return "Page Number does not exist";
		}
		else{
			// Find the start index using the page number present in the request and give the next 10 results.
			int startIndex = (pgNo-1) * 10; 
			ArrayList<DeckWithoutCards> deckDetails = new ArrayList<DeckWithoutCards>();
			ArrayList<DeckWithoutCards> allDeckDetails= new ArrayList<DeckWithoutCards>();
			allDeckDetails = deckConstants.getDeckwithoutCardsList();
			for(int i=0 ;i<10; i++){
				
				if(startIndex < allDeckDetails.size()){
					deckDetails.add(i,allDeckDetails.get(startIndex));
					startIndex++;
				}
				else{
					break;
				}				
			}
			
			int totalResults = deckConstants.getDeckwithoutCardsList().size();
			//Set the next page's token. For last page point that the next page is the 1st page
			int nextPageToken = (pgNo + 1 > Math.ceil(deckConstants.getDeckwithoutCardsList().size()/10.0))
									? 1: pgNo +1;															
			
			Deck deck = new Deck(deckDetails,nextPageToken,totalResults);				
			ObjectMapper obj = new ObjectMapper();
			String result = obj.writeValueAsString(deck);
			
			return result;
		}
		
	}
	
	
	//The following request returns the deck object given its Id.
	@RequestMapping(value = "/decks/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	private String getDeckDataWithId(@PathVariable int id,HttpServletRequest request) throws JsonProcessingException{
		if(id == 0){
			return "Id starts from 1";
		}
		HashMap<Integer,DeckWithCards> deckWithCards = new LinkedHashMap<Integer,DeckWithCards>
															(deckConstants.getDeckWithCards());
		DeckWithCards deckWithId = new DeckWithCards();
		//Check if Id is present to obtain the deck
		if(deckWithCards.containsKey(id)){
			deckWithId = deckWithCards.get(id);	
		}
		else{
			return "The Deck for given Id does not exist";
		}
		ObjectMapper obj = new ObjectMapper();
		String result = obj.writeValueAsString(deckWithId);
		System.out.println(result);
		return result;
	}
	
	
	//The following function returns the combined deck response- This is paginated as 5 responses per page
	@RequestMapping(value = "/users/user1/decks/combinedResponse", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	private String getCombinedResponse(HttpServletRequest request) throws JsonProcessingException{
		HashMap<Integer,DeckWithCards> deckWithCards = new LinkedHashMap<Integer,DeckWithCards>
															(deckConstants.getDeckWithCards());
		
		CombinedResponse combinedResponse = new CombinedResponse();
		ArrayList<DeckWithCards> finalDeckList = new ArrayList<DeckWithCards>();
		for(Map.Entry<Integer,DeckWithCards> d: deckWithCards.entrySet()){
			finalDeckList.add(d.getValue());
		}
		combinedResponse.setDecks(finalDeckList);
		combinedResponse.setNextPageToken(2);
		combinedResponse.setResultSizeEstimate(10);
		
		ObjectMapper obj = new ObjectMapper();
		String result = obj.writeValueAsString(combinedResponse);
		System.out.println(result);
		return result;
	}
}
