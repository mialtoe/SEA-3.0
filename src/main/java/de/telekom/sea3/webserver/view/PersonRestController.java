package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;




@RestController
public class PersonRestController {
	
	private PersonService personService;
    
	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService = personService;
		System.out.println("PersonController angelegt"+this.toString());
		System.out.println("ServiceController angelegt"+personService.toString());

	}	   
	   
	
	@GetMapping("/json/persons/all")                   // URL:"http://localhost:8080/json/persons/all"
	public Personen getAllPersons() {
	   Personen personen = personService.getAllPersons();
       return personen;  
		
		/* String string1 = "{\n"                        // temporär zum Test manuell erzeugtes Json
				+ "	\"personen\": [\n"
				+ "		{\n"
				+ "			\"anrede\": \"Herr\",\n"
				+ "			\"vorname\": \"Paul\",\n"
				+ "			\"nachname\": \"Paulsen\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"anrede\": \"Frau\",\n"
				+ "			\"vorname\":  \"Sabine\",\n"
				+ "			\"nachname\": \"Christiansen\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"anrede\": \"Keine\",\n"
				+ "			\"vorname\": \"Karl\",\n"
				+ "			\"nachname\": \"Napp\"\n"
				+ "		}\n"
				+ "	]\n"
				+ "}";
//		String string = String.format(HTMLTEMPLATE,  personService.getSize());
		
		return string1; */
	}
	
	@GetMapping("/json/persons/size")                   // URL:"http://localhost:8080/json/persons/all"
	public Size getSize() {
		return new Size(personService.getSize());

		/* manuell erstelltes Json zum Test
		String string = "{\n"
				+ "	\"size\": %d\n"
				+ "}";
        string = String.format(string,  size);
		
		return string;*/
	}

	@GetMapping("/json/person/{id}")                   
	public Person getPerson(@PathVariable("id") int id) {
		return personService.getPerson(id);
	}

	@PostMapping("/json/person")                   
	public Person addPerson(@RequestBody Person p) {
		return personService.addPerson(p); 
	}
	
	@DeleteMapping ("/json/person/{id}")
	public void deletePerson(@PathVariable("id") String id){
		int idInt = Integer.parseInt(id);
		personService.deletePerson(idInt);
	}
	
}
