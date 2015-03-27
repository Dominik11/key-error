/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.text.mvc.spring.dao;

import org.springframework.data.repository.CrudRepository;
import pl.altkom.text.mvc.spring.model.Person;

/**
 *
 * @author Acer
 */
public interface PersonDAO extends CrudRepository<Person, Integer>{
    
}
