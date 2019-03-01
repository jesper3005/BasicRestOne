/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Person;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jesper
 */
public class PersonFacadeTest {

    PersonFacade facade = new PersonFacade();

    @Before
    public void setUp() {
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu", null));
    }

    @Test
    public void addPerson() {
        List<Person> personsBefore = facade.getAllPersons();
        Person person = new Person("Jesper", "Christensen", "22817333");
        facade.addPerson(person);
        List<Person> persons = facade.getAllPersons();
        Assert.assertEquals(personsBefore.size() + 1, persons.size());
    }
    
    @Test
    public void getAllPersons() {
        List<Person> persons = facade.getAllPersons();
        Assert.assertFalse(persons.isEmpty());
    }
    
    @Test
    public void getPerson() {
        List<Person> persons = facade.getAllPersons();
        Person person = facade.getPersonById(persons.get(0).getId());
        System.out.println(person);
        Assert.assertEquals(persons.get(0).getFirstName(), person.getFirstName());
    }
    
    @Test
    public void deletePerson() {
        List<Person> personsBefore = facade.getAllPersons();
        Person person = facade.getPersonById(personsBefore.get(0).getId());
        facade.deletePersonById(person.getId());
        List<Person> personsAfter = facade.getAllPersons();
        
        Assert.assertEquals(personsBefore.size() - 1, personsAfter.size());
    }
    
//    @Test
//    public void editPerson() {
//        Person personBefore = facade.getPersonById(1);
//        
//        facade.editPerson(personBefore);
//        
//        Person personAfter = facade.getPersonById(1);
//        
//    }
}
