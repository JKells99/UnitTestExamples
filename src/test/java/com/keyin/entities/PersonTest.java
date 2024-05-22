package com.keyin.entities;

import com.keyin.entities.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonTest {

    @Test
    public void createPerson(){

        List<Person> listOfCreatedPeople = new ArrayList<>();
        Person bob = new Person("Bob","Smith","123-123-1333");
        Person bob2 = new Person("Bob2","Smith","123-123-1366");

        listOfCreatedPeople.add(bob);
        listOfCreatedPeople.add(bob2);

        Assertions.assertTrue(listOfCreatedPeople.size()==2);




    }


    @Test
    public void testEditPerson(){
        Person person = new Person("Bob","Smith","123-123-1333");

        person.setFirstName("Jordan");

        Assertions.assertTrue(Objects.equals(person.getFirstName(), "Jordan"));
    }
}
