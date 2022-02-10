package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	private final PersonService personService;

	public Application(PersonService personService) {
		this.personService = personService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init(){
		Person person = new Person();
		Person person1 = new Person();
		Person person2 = new Person();
		person.setFirstName("ana");
		person1.setFirstName("patricia");
		person2.setFirstName("asucena");
		person.setLastName("mor");
		person1.setLastName("carraanza");
		person2.setLastName("azofeifa");
		person.setEmail("ana@gmail.com");
		person1.setEmail("ana@gmail.com");
		person2.setEmail("ana@gmail.com");
		personService.createPerson(person);
		personService.createPerson(person1);
		personService.createPerson(person2);
	}
}
