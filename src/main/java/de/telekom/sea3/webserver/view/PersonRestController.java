package de.telekom.sea3.webserver.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//import de.telekom.sea3.webserver.model.*;
//import de.telekom.sea3.webserver.repo.PersonRepository;


//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
//import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;


/**
 * 
 * @author Michael Altoe
 *
 */

@RestController
public class PersonRestController {
	
	private PersonService personService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
    
	/**
	 * Konstruktor (@Autowired)
	 * @param personService Verbindung zur Serviceschicht
	 */
	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService = personService;
		logger.info(String.format("PersonController angelegt %s", this.toString()));
		logger.info(String.format("ServiceController angelegt %s", personService.toString()));
//		System.out.println("PersonController angelegt"+this.toString());
//		System.out.println("ServiceController angelegt"+personService.toString());
	}	   
	   
	/**
	 * Endpunkt /json/persons/all um alle Personen auszulesen 
	 * @return Vorhandene Personen werden zurück gegeben
	 */
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
	
/*	@GetMapping("/json/persons/size")                   // URL:"http://localhost:8080/json/persons/all"
	public Size getSize() {
		return new Size(personService.getSize());

		/* manuell erstelltes Json zum Test
		String string = "{\n"
				+ "	\"size\": %d\n"
				+ "}";
        string = String.format(string,  size);
		
		return string;
	}*/

    /**
     * Endpunkt um eine einzelne Person zu holen, identifiziert über die Id
     * @param id Id unter der die gesuchte Person abgelegt ist
     * @return Die gefundene Person wird zurück gegeben.
     */
	@GetMapping("/json/person/{id}")                   
	public Person getPerson(@PathVariable("id") int id) {
		return personService.getPerson(id);
	}

	/**
	 * Endpunkt um eine neue Person hinzu zu fügen.
	 * @param person Person die hinzugefügt werden soll
	 * @return Hinzugefügte Person wird zurück gegeben.
	 */
	@PostMapping("/json/person")                   
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person); 
	}
	
	/**
	 * Endpunkt um ein Update auf eine Person durchzuführen
	 * @param p Eine Person
	 * @return Person auf die ein Update durcgeführt worden ist wird zurück gegeben.
	 */
	@PutMapping("/json/person")                   
	public Person updatePerson(@RequestBody Person p) {
		return personService.addPerson(p); 
	}

	/**
	 * Die Person mit der übergebenen Id wird gelöscht.
	 * @param id Id unter der die Person abgelegt ist
	 */
	@DeleteMapping ("/json/person/{id}")
	public void deletePerson(@PathVariable("id") String id){
		int idInt = Integer.parseInt(id);
		personService.deletePerson(idInt);
	}
	
	/**
	 * Test eines selbstgebastelten SQL, das nicht standardmäßig von Spring bereitgestellt wird
	 * Aufruf: http://localhost:8080/json/select?search="searchstring"     
	 * @param searchstring - hier name oder vorname
	 * @return liefert die gesuchten Personen (Typ: Personen) zurück
	 */
	//zum Aufruf von selbsgebastelten SQL
	//Aufruf: http://localhost:8080/json/select?search=<suchstring>     (name oder vorname)
	@GetMapping("/json/select")
	public Personen selpersonen(@RequestParam (name="search", required=false) String searchstring) {
		logger.info(String.format("SEARCHSTRING %s", searchstring));
		Personen ps= personService.selPersonen(searchstring);
		return ps;
	}
	
	
}
