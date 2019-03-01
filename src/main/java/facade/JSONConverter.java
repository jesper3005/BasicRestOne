/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class JSONConverter {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }

    public static String getJSONFromPerson(Person p) {
        return gson.toJson(p);
    }

    public static String getJSONFromPersons(List<Person> persons) {
        return gson.toJson(persons);
    }
}