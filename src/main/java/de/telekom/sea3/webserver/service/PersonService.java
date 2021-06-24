package de.telekom.sea3.webserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import de.telekom.sea3.webserver.model.*;

//import de.telekom.sea3.webserver.view.*;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
		logger.info(String.format("PersonService angelegt %s", this.toString()));
		logger.info(String.format("PersonRepo angelegt %s", personRepository.toString()));
//		System.out.println("PersonService angelegt" + this.toString());
//		System.out.println("PersonRepo angelegt" + personRepository.toString());
	}

	public long getSize() {
		return personRepository.count();
	}

	public Personen getAllPersons() {
		Personen ps = new Personen();
		for (Person p : personRepository.findAll()) {
			ps.getPersonen().add(p);
		}
		return ps;
//		return personRepository.findAll();
	}

	public Person getPerson(int id) {
		// return new Person("Hans","Meiser","Herr");
		Person p = personRepository.findById(id).get();
		logger.info(String.format("Get*******************: %s %s", p.getNachname(), p.getVorname()));
//		System.out.println("Get*******************:" + p.getNachname() + "," + p.getVorname());
		return p;
	}

	public Person addPerson(Person person) {
		personRepository.save(person);
		logger.info("Person wurde angelegt");
//		System.out.println("Person wurde angelegt");
		return person;
	}

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

}
