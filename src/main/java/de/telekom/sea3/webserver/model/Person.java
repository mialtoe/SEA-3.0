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

/**
 * Eine Person 
 * Die Person wird abgelegt in der Tabelle "person"  (Spring Boot: @Entity, @Table)
 * @author Michael Altoe
 *
 */


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
	
	/**
	 * Konstruktor
	 */
	public Person () {
    }
	
	/**
	 * eine Person mit all seinen Attributen
	 * 
	 * @param vorname Vorname
	 * @param nachname Nachname
	 * @param anrede Anrede
	 * @param email Email-Adresse
	 * @param gebdatum Geburtsdatum
	 */
	public Person (String vorname, String nachname, String anrede, String email, LocalDate gebdatum) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.anrede = anrede;
		this.email = email;
		this.gebdatum = gebdatum;
	}

	/**
	 * Getter
	 * @return Geburtsdatum
	 */
	public LocalDate getGebdatum() {
		return gebdatum;
	}

	/**
	 * Setter 
	 * @param gebdatum Geburtsdatum 
	 */
	public void setGebdatum(LocalDate gebdatum) {
		this.gebdatum = gebdatum;
	}

	/**
	 * Getter
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter Email
	 * @param email Email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter
	 * @return Vorname
	 */
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Setter Vorname
	 * @param vorname Vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/**
	 * Getter
	 * @return Nachname
	 */
    public String getNachname() {
		return nachname;
	}
    
	/**
	 * Setter Nachname
	 * @param nachname Nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	/**
	 * Getter
	 * @return Anrede
	 */
	public String getAnrede() {
		return anrede;
	}
	
	/**
	 * Setter Anrede
	 * @param anrede Anrede
	 */
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	
	/**
	 * Getter
	 * @return Id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter Id
     * @param id Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return Version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * Setter Version
     * @param version Version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
}
