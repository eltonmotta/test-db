package com.example.testdb.controller;

import com.example.testdb.entity.Person;
import com.example.testdb.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class PersonApiController {


    private final PersonService service;

    public PersonApiController(PersonService service) {
        this.service = service;
    }


    @PostMapping("/persons")
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersons() {
        return service.getAllPersons();
    }

}
