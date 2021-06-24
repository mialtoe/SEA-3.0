package de.telekom.sea3.webserver.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;

@Repository
public class PersonRepositoryOld {
   
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// private List<Person> personen= new ArrayList<Person>();
	private Personen personen = new Personen();

	
	public PersonRepositoryOld() {
		logger.info(String.format("PersonRepo angelegt: %s",this.toString()));
//		System.out.println("PersonRepo angelegt: " + this.toString());
	}	
	
	public int getSize() {
		return personen.size();
	}
	
	public Personen getAll() {
		return personen; 
	}
	
	public Person getPerson(int id) {
		return personen.getPerson(id);
	}
	
	public Person addPerson(Person p) {
		personen.addPerson(p);
		return p;		
	}
	
	public void deletePerson(int idInt) {
		personen.deletePerson(idInt-1);
	}

   	
}
