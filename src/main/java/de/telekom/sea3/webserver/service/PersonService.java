/**
 * Serviceschicht für die Verwaltung von Personen
 */
package de.telekom.sea3.webserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import de.telekom.sea3.webserver.model.*;

//import de.telekom.sea3.webserver.view.*;
import de.telekom.sea3.webserver.repo.PersonRepository;
/**
 * Serviceschicht für die Verwaltung von Personen
 *
 * @author Michael Altoe
 * @version 1.0
 * @since Version 1.0
 */
@Service
public class PersonService {

	private PersonRepository personRepository;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Konstruktor (@Autowired) 
	 * @param personRepository Personen Repository
	 * 
	 */
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
		logger.info(String.format("PersonService angelegt %s", this.toString()));
		logger.info(String.format("PersonRepo angelegt %s", personRepository.toString()));
//		System.out.println("PersonService angelegt" + this.toString());
//		System.out.println("PersonRepo angelegt" + personRepository.toString());
	}
    
	/**
	 * Ermittelt die Anzahl der vorhandenen Personen
	 * @return Anzahl der vorhandenen Personen
	 */
	public long getSize() {
		return personRepository.count();
	}
    
	/**
	 * Alle vorhandenen Personen werden gesucht
	 * @return gibt alle vorhandenen Personen (Typ: Personen) zurück
	 */
	public Personen getAllPersons() {
		Personen ps = new Personen();
		for (Person p : personRepository.findAll()) {
			ps.getPersonen().add(p);
		}
		return ps;
//		return personRepository.findAll();
	}
    
	/**
	 * Eine einzelne Person wird gezielt gesucht
	 * @param id die id der gesuchten Person
	 * @return Gibt die Person mit der Id id zurück
	 */
	public Person getPerson(int id) {
		// return new Person("Hans","Meiser","Herr");
		Person p = personRepository.findById(id).get();
		logger.info(String.format("Get*******************: %s %s", p.getNachname(), p.getVorname()));
//		System.out.println("Get*******************:" + p.getNachname() + "," + p.getVorname());
		return p;
	}
    
	/**
	 * Eine neue Person wird hinzugefügt oder falls vorhanden wird ein Update durchgeführt
	 * @param person neue / zu ändernde Person
	 * @return die neu angelegte oder geänderte Person wird zurück gegeben
	 */
	public Person addPerson(Person person) {
		personRepository.save(person);
		logger.info("Person wurde angelegt");
//		System.out.println("Person wurde angelegt");
		return person;
	}

	/**
	 * Die Person mit der übergebenen Id wird gelöscht.
	 * @param idInt Id unter der die Person abgelegt ist
	 */
	public void deletePerson(int idInt) {
		try {
			personRepository.deleteById(idInt);
			logger.info(String.format("Person mit ID %d wurde gelöscht.", idInt));
//			System.out.println(String.format("Person mit ID %d wurde gelöscht.", idInt));
		} catch (Exception e) {
			logger.info(String.format("Person mit ID %d wurde nicht zum Löschen gefunden", idInt));
//			System.out.println(String.format("Person mit ID %d wurde nicht zum Löschen gefunden", idInt));
		}
	}
	
	/**
	 * Test eines selbstgebastelten SQL, das nicht standardmäßig von Spring bereitgestellt wird 
	 * @param searchstring Wonach soll gesucht werden?
	 * @return die gesuchte Person wird zurückgeliefert
	 */
	// selbstgebasteltes SQL 
	public Personen selPersonen(String searchstring) {
		Personen ps = new Personen();
		for (Person p : personRepository.selectPersonen(searchstring)) {
			ps.getPersonen().add(p);
		}
		return ps;
	}
	/**
	 * <span style="color:red">Test, ob protected Methode in JavaDoc-Doku auftaucht</span>
	 */
	protected void JavadocTest () {
		
	}


}
