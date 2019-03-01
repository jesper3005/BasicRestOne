/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jesper
 */
public interface IPersonFacade {
    
    public void addEntityManagerFactory(EntityManagerFactory emf);

    public Person addPerson(Person p);

    public Person deletePersonById(int id);

    public Person getPersonById(int id);

    public List<Person> getAllPersons();

    public Person editPerson(Person p);
    
}
