package de.telekom.sea3.webserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.*;

//import de.telekom.sea3.webserver.view.*;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {
      
	private PersonRepository personRepository;
    
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
		System.out.println("PersonService angelegt"+this.toString());
		System.out.println("PersonRepo angelegt"+personRepository.toString());
	}
	
	public long getSize() {
		return personRepository.count();
	}

	public Personen getAllPersons() {
		Personen ps = new Personen();
		for (Person p:personRepository.findAll()) {
			ps.getPersonen().add(p);
		}
		return ps;
//		return personRepository.findAll();
	}
	

	public Person getPerson(int id) {
		//return new Person("Hans","Meiser","Herr");
		Person p = personRepository.findById(id).get();
		System.out.println("Get*******************:"+p.getNachname()+","+p.getVorname());
		return p;
	}

	public Person addPerson(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde angelegt");
		return person;
	}

	public void deletePerson(int idInt) {
		System.out.println("Person wurde gelöscht.");
		personRepository.deleteById(idInt);
	}
	
	
	
}
