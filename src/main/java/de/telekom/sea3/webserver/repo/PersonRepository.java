package de.telekom.sea3.webserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.telekom.sea3.webserver.model.*;

/**
 * Interface: Personen Repository
 * @author Michael Altoe
 *
 */

public interface PersonRepository  extends JpaRepository<Person, Integer>{

	/**
	 * Hier können selbstgebastelte SQL abgesetzt werden, die nicht von Spring zur Verfügung gestellt werden (@Query)
	 * @param searchstring wonach soll gesucht werden
	 * @return gefundene Personen
	 */
	// hier können selbstgebastelte SQL abgesetzt werden, die nicht von Spring zur Verfügung gestellt werden 
	@Query(value="SELECT * from person where vorname=:sstring or nachname=:sstring",nativeQuery=true )
	Iterable<Person> selectPersonen(@Param("sstring") String searchstring);
}
