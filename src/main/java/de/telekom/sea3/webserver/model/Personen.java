package de.telekom.sea3.webserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


// wird benötigt um die JSON Struktur korrekt zu erstellen --> Personen - Struktur in JSON
public class Personen {
    
	private List<Person> personen= new ArrayList<Person>();

//	public Personen(List<Person> all) {
//        this.personen=all;
//	}

	public List<Person> getPersonen() {
		return personen;
	}

	public void setPersonen(List<Person> personen) {
		this.personen = personen;
	} 
	
	public void addPerson(Person p) {
		personen.add(p);
	}
	
	public Person getPerson(int id) {
		return personen.get(id);
	}
	
	public int size() {
		return personen.size();
	}	

	public void deletePerson(int idInt) {
		personen.remove(idInt);
	}
	
}
