package org.example;

import java.util.UUID;

public class Student {
    //set variables
    private final UUID id;
    private final String name;
    private final String surname;

    //set constructor
    Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }
    // getters
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
