package de.telekom.sea3.webserver.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	private Hund hund;

	@Autowired
	public Person(Hund hund) {
		this.hund = hund;
		System.out.println(this.hund.toString());
		System.out.println("Instanz erzeugt");
	}
}
