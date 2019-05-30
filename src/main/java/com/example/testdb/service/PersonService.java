package com.example.testdb.service;

import com.example.testdb.entity.Person;
import com.example.testdb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Iterable<Person> getAllPersons() {
        return repository.findAll();
    }

}
