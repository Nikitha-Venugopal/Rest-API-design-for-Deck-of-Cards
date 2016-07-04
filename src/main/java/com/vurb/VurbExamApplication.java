package com.vurb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vurb.constants.DeckData;


@SpringBootApplication
public class VurbExamApplication {
	public static ConfigurableApplicationContext context;
	
	@Autowired
	public static DeckData deckConstants;
	
	public static void main(String[] args) {
		deckConstants = new DeckData();
		deckConstants.buildDeckData();		
		//SpringApplication.run(VurbExamApplication.class, args);		
		SpringApplication app =new SpringApplication(VurbExamApplication.class);
		context = app.run(args);
				
		
	}
}
