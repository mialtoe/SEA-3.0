package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonHtmlController {
	
	private static final String HTMLTEMPLATE="<!DOCTYPE html> <html lang=\'de\'> "
            + "<head> <meta charset=\'utf-8\'> <meta name=\'viewport\' content=\'width=device-width, initial-scale=1.0\'> <title>Titel</title></head>"
            + "<body>Size: %d </body> </html>"; 

	private PersonService personService;
    
	@Autowired
	public PersonHtmlController(PersonService personService) {
		this.personService = personService;
	}	   
	
	
	@GetMapping("/size")                   // URL:"http://localhost:8080/size"
	@ResponseBody                          // Spring Framework gibt HTML zurück
	public String getSize() {
		
		/* Varianten um aus einem int einen String zu machen
		String string = Integer.toString(personService.getSize());  
		String string = String.valueOf(personService.getSize());
		String string = String.format("%d",  personService.getSize());
		String string = "" + personService.getSize(); */
		
		String string = String.format(HTMLTEMPLATE,  personService.getSize());
		
		return string;
	}
	
}
