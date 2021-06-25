package de.telekom.sea3.webserver.model;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;

/**
 * Klammer um Personen. Mehrere Personen werden zu einem Json Objekt zusammengefasst   
 * 
 * @author Michael Altoe
 *
 */
// wird benötigt um die JSON Struktur korrekt zu erstellen --> Personen - Struktur in JSON
public class Personen {
    
	private List<Person> personen= new ArrayList<Person>();

//	public Personen(List<Person> all) {
//        this.personen=all;
//	}

	/**
	 * Getter
	 * Gibt eine Liste von Personen (Typ:Person) zurück
	 * @return Liste von Personen
	 */
	public List<Person> getPersonen() {
		return personen;
	}

	/**
	 * Setter
	 * @param personen Liste der Personen
	 */
	public void setPersonen(List<Person> personen) {
		this.personen = personen;
	} 
	
	/**
	 * Fügt der Liste der Personen eine Liste hinzu
	 * @param person eine neue Person
	 */
	public void addPerson(Person person) {
		personen.add(person);
	}
	
	/**
	 * Holt Person mit der gesuchten Id aus Personen heraus
	 * @param id Id der gesuchten Person
	 * @return gesuchte Person
	 */
	public Person getPerson(int id) {
		return personen.get(id);
	}

	
//	public int size() {
//		return personen.size();
//	}	

	/**
	 * Löscht eine Person aus der Liste
	 * @param idInt Id der zu löschenden Person
	 */
	public void deletePerson(int idInt) {
		personen.remove(idInt);
	}
	
}
