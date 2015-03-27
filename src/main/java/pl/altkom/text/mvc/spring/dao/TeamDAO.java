/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.altkom.text.mvc.spring.dao;

import org.springframework.data.repository.CrudRepository;
import pl.altkom.text.mvc.spring.model.Team;
 

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface TeamDAO  extends CrudRepository<Team, Integer>{
    
}
