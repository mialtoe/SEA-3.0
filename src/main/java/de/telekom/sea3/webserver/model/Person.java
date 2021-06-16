package de.telekom.sea3.webserver.model;

public class Person {
	
	private String vorname;
	private String nachname;
	private String anrede;
	private String email;

	public Person (String vorname, String nachname, String anrede, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.anrede = anrede;
		this.email = email;
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
}
