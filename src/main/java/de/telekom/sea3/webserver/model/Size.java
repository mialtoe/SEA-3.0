package de.telekom.sea3.webserver.model;

/**
 * Ermittelt die Anzahl der Personen, keine Verwendung mehr mit Spring Boot
 * @author Michael Altoe
 *
 */

public class Size {

	private int size;
	
	/**
	 * Konstruktor 
	 * @param size Anzahl Personen
	 */
	public Size (int size) {
       this.size=size;
    }

	/**
	 * Getter 
	 * @return Anzahl Personen 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter
	 * @param size Anzahl Personen
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
