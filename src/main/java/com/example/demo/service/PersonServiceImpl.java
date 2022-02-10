package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person personUpdate, Long id) {
        Person person = this.getPerson(id);
        person.setFirstName(personUpdate.getFirstName());
        person.setLastName(personUpdate.getLastName());
        person.setEmail(person.getEmail());
        return this.createPerson(person);
    }

    @Override
    public void deletePerson(Long id) {

    }

    @Override
    public Person getPerson(Long id) {
        assert id != null;
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
