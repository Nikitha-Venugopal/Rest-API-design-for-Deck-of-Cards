# Vurb_Coding_Exam

The Environment set-up is as follows:
1. The web-application was built as a Spring application.

The Application start-up can be done by importing the code into an eclipse/STS tool.

The Application under the package- com.vurb named as "VurbExamApplication" can be run from there.

OR

1. Download maven and set its path in the PATH variable.
2. To check if it is installed properly, open command prompt and type the following:
	>mvn --version
	
	It should give the output something like this specifying maven version:
	
	Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T04:57:37-07:00)
	Maven home: C:\apache-maven-3.3.3
	Java version: 1.7.0_79, vendor: Oracle Corporation
	Java home: C:\Program Files\Java\jdk1.7.0_79\jre
	Default locale: en_US, platform encoding: Cp1252
	OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "windows"
	
3. Extract the source code from the zipped file attached in the e-mail.
4. Open Command Prompt.
5. 'cd' to the project directory where 'pom.xml' is present.
6. Once inside this directory, type in the following command:
	>mvn spring-boot:run
7. The application starts on your localhost on port 8080.
8. Now go the browser and type in: localhost:8080.
9. A page with "Hello.. This is Vurb Exam" opens up which means the server is up and running
	and we can make rest calls either from the browser or from a client like- POSTMAN.
	
Refer the Description.txt file for all the design information and REST calls to be made.

The below is the exam description:

A Card is the smallest data unit that represents information about an entity. These cards can be  saved into decks that are owned by users. Thus, A deck is a collection of cards.

Need to create decks end-point with the following REST services whose sample responses are also given:

1. GET /users/{userName}/decks
{    
"decks": [  
	{
		 "id": string,
		 "desc": string,
    },      
   ...    ],
    "nextPageToken": string,
    "resultSizeEstimate": integer
 }  
2. GET /decks/{id}
{    
"id": string,    
"desc": string,    
	"cards": [      {        
		"id": string,        
		"title": string,        
		"payload": {          
			...        }      
				},      
			...    ]  
}  
3. GET /users/{userName}/decks/combinedResponse
{    "decks": [     
	{       
		"id": string,       
		"desc": string,       
		"cards": [        {          
			"id": string,          
			"title": string,          
			"payload": {            ...          }        
			},        
			...      ]    
	},    
		...    ],    
"nextPageToken": string,    
"resultSizeEstimate": integer  
} 

