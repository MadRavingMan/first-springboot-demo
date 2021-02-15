package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person getById(long pid) throws PersonNotFoundException;

    void delete(long pid) throws PersonNotFoundException;

    Person updatePerson(Person person) throws  PersonNotFoundException;

    //    void addPerson(Person person);


}
