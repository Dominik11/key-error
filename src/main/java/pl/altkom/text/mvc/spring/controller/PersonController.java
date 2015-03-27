/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.text.mvc.spring.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.altkom.text.mvc.spring.dao.PersonDAO;
import pl.altkom.text.mvc.spring.dao.TeamDAO;
import pl.altkom.text.mvc.spring.model.Person;

/**
 *
 * @author Acer
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonDAO personDAO;
    
     @Autowired
    private TeamDAO teamDAO;
    
    @RequestMapping("/add")
    public ModelAndView add(){
        
        ModelAndView modelAndView = new ModelAndView("add");
         
        Person person = new Person();
        modelAndView.addObject("person", person);
        modelAndView.addObject("teams", teamDAO.findAll());
        
        return modelAndView;
        
   
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String savePerson(@Valid Person person, BindingResult binding) {
        
        if(binding.hasErrors()) {
            return "addPerson";
        } else {
            System.out.println(person);
            personDAO.save(person);
            return "redirect:/person/list.htm";
        }
    }
    
    
     @RequestMapping("/list")
    public ModelAndView list() {
        Iterable<Person> res = personDAO.findAll();
        
        ModelAndView model = new ModelAndView("personList");
        model.addObject("persons", res);
        
        return model;
        
    }
    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam int id) {
        
        ModelAndView model = new ModelAndView("add");
        
        Person person = personDAO.findOne(id);
        model.addObject("person", person);
        model.addObject("teams", teamDAO.findAll());
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Person person, BindingResult bindingResult){
        
        System.out.println(person);
         
       if( bindingResult.hasErrors()){
           
           return "add";
       }
       personDAO.save(person);
        
        return "redirect:/home.htm";
    }
    
    
}
