package de.telekom.sea3.webserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import de.telekom.sea3.webserver.model.*;

public interface PersonRepository  extends JpaRepository<Person, Integer>{

}
