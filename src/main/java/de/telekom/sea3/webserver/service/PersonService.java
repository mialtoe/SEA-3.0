package de.telekom.sea3.webserver.service;

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
	
	public int getSize() {
		return personRepository.getSize();
	}

	public Personen getAllPersons() {
		return new Personen(personRepository.getAll());
	}
	
	public Person get(int id) {
		return new Person("Hans","Meiser","Herr");
	}

	public Person add(Person person) {
		personRepository.add(person);
		System.out.println("Person wurde angelegt");
		return person;
	}
	
}
