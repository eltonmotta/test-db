package com.example.testdb.controller;

import com.example.testdb.entity.Person;
import com.example.testdb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class PersonApiController {


    @Autowired
    private PersonRepository repository;


    @PostMapping("/persons")
    public Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersons() {
        return repository.findAll();
    }

}
