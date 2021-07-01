package de.telekom.sea3.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Webserver
 * @author Michael Altoe
 * 
 */

@SpringBootApplication
public class WebServer {
	/**
	 * Main Methode
	 * @param args Parameter von aussen, falls vorhanden
	 */
    public static void main(String[] args) {
        SpringApplication.run( WebServer.class, args);
        
   }
}

