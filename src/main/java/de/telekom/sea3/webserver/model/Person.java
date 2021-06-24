package de.telekom.sea3.webserver.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;


//CREATE TABLE person ( id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, nachname VARCHAR(255), vorname VARCHAR(255), email VARCHAR(255), anrede VARCHAR(12), gebdatum DATE, version BIGINT NOT NULL);

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="version")
	@Version                    // verhindert lost SQL, gleichzeitiges Ändern  
	private Long version;

	@Column(name="vorname")
	private String vorname;
	
	@Column(name="nachname")
	private String nachname;
	
	@Column(name="anrede")
	private String anrede;
	
	@Column(name="email")
	private String email;

	@Column(name="gebdatum")
	private LocalDate gebdatum;
	
	public Person () {
    }
	
	
	public Person (String vorname, String nachname, String anrede, String email, LocalDate gebdatum) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.anrede = anrede;
		this.email = email;
		this.gebdatum = gebdatum;
	}

	public LocalDate getGebdatum() {
		return gebdatum;
	}

	public void setGebdatum(LocalDate gebdatum) {
		this.gebdatum = gebdatum;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
