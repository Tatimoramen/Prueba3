package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
   private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> get(){
        List<Person> personList = personService.getPersons();
        return ResponseEntity.ok().body(personList);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person){
        Person personSaved = personService.createPerson(person);
        return ResponseEntity.ok().body(personSaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> put(@PathVariable("id") Long id, @RequestBody Person person){
        Person personUpdated = personService.updatePerson(person,id);
        return ResponseEntity.ok().body(personUpdated);
    }
}
