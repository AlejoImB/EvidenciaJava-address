package com.Alejandro.c24.service;


import com.Alejandro.c24.entity.Person;
import com.Alejandro.c24.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}