package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.person.exception.PersonAlreadyExistException;
import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(final long pid) throws PersonNotFoundException {
        Person person = personRepository.findById(pid).orElseThrow(() -> new PersonNotFoundException(pid));
        return person;
    }

    @Override
    public void delete(final long pid) throws PersonNotFoundException {
        Person person = personRepository.findById(pid).orElseThrow(() -> new PersonNotFoundException(pid));
        personRepository.deleteById(pid);
    }

    @Override
    public void addPerson(Person person) throws PersonAlreadyExistException {
        if (personRepository.findById(person.getPid()).isEmpty()) {
            personRepository.save(person);
        } else {
            new PersonAlreadyExistException(person.getPid());
        }
    }


    @Override
    public void updatePerson(Person updatePerson) throws PersonNotFoundException {
        Person existingPerson = personRepository.findById(updatePerson.getPid())
                .orElseThrow(() -> new PersonNotFoundException(updatePerson.getPid()));

        existingPerson.setName(updatePerson.getName());
        existingPerson.setMiddleName(updatePerson.getMiddleName());
        existingPerson.setSurname(updatePerson.getSurname());
        existingPerson.setEmail(updatePerson.getEmail());
        existingPerson.setPhone(updatePerson.getPhone());
        personRepository.save(existingPerson);
    }
}
