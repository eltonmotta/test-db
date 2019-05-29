package com.example.testdb.controller;

import com.example.testdb.entity.Person;
import com.example.testdb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/showAddPerson")
    public String showAddPerson(Person person) {
        return "add-person";
    }

    @PostMapping("/addPerson")
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-person";
        }

        repository.save(person);
        model.addAttribute("persons", repository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showEditPerson(@PathVariable("id") Integer id, Model model) {
        Person person = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "update-person";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Integer id, @Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            person.setId(id);
            return "update-person";
        }

        repository.save(person);
        model.addAttribute("persons", repository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id, Model model) {
        Person user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repository.delete(user);
        model.addAttribute("persons", repository.findAll());
        return "index";
    }

}
