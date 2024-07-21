package com.Alejandro.c24.service;

import com.Alejandro.c24.entity.Person;

import java.util.List;

public interface    PersonService {
    List<Person> getAllPersons();
    Person createPerson(Person person);
}