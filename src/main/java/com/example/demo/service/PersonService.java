package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person person, Long id);
    void deletePerson(Long id);
    Person getPerson(Long id);
    List<Person> getPersons();
}
