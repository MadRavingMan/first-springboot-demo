package com.swedbank.academy.demoserver.person.exception;

public class PersonAlreadyExistException extends Exception {

    public PersonAlreadyExistException(long pid) {
        super("Person with this " + pid +" pID already exist");
    }
}
