package com.swedbank.academy.demoserver.person.exception;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(long pid) {
        super("Can't find person with " + pid);
    }
}
