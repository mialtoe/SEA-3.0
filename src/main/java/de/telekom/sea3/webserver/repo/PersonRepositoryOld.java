package de.telekom.sea3.webserver.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
/**
 * Personen Repository ohne JpaRepository
 * Findet mit Änderung auf JpaRepository keine Verwendung mehr!
 * 
 * @author Michael Altoe
 * @deprecated Alte Klasse vor Umstellung auf Spring Boot.
 * Wird ersetzt durch Interface {@link PersonRepository}.
 * Funktionalität der Methoden verlagert in {@link de.telekom.sea3.webserver.service.PersonService} 
 * 
 */

@Repository
public class PersonRepositoryOld {
   
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// private List<Person> personen= new ArrayList<Person>();
	private Personen personen = new Personen();

	/**
	 * Konstruktor
	 */
	public PersonRepositoryOld() {
		logger.info(String.format("PersonRepo angelegt: %s",this.toString()));
//		System.out.println("PersonRepo angelegt: " + this.toString());
	}	
	
	/**
	 * Ermittelt Anzahl Personen
	 * @return Anzahl der Personen wird zurück gegeben.
	 * @deprecated Alte Methode zum Ermitteln der vorhandenen Anzahl der Personen, wird mit Umstellung auf Spring Boot nicht mehr verwendet
	 */
	public int getSize() {
		return personen.size();
	}
	
	/**
	 * Alle Personen werden ausgelesen
	 * @return Alle gefundenen Personen (Typ: Personen) werden zurück gegeben
	 * {@link getPerson(int)}
	 */
	public Personen getAll() {
		return personen; 
	}
	
	/**
	 * Eine einzelne Person wird gezielt gesucht
	 * @param id die id der gesuchten Person
	 * @return Gibt die Person mit der Id id zurück
	 */
	public Person getPerson(int id) {
		return personen.getPerson(id);
	}
	
	/**
	 * Eine neue Person wird hinzugefügt 
	 * @param person hinzuzufügende Person
	 * @return die neu angelegte Person wird zurück gegeben
	 */
	public Person addPerson(Person person) {
		personen.addPerson(person);
		return person;		
	}
	
	/**
	 * Die Person mit der übergebenen Id wird gelöscht.
	 * @param idInt Id der zu löschenden Person
	 */
	public void deletePerson(int idInt) {
		personen.deletePerson(idInt-1);
	}

   	
}
