package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
    
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
		System.out.println("PersonController angelegt"+this.toString());
		System.out.println("ServiceController angelegt"+personService.toString());

	}	   
	   
}
