package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    //obiekt zyje w cyklu aplikacji
    @Autowired
    private PersonRepository personRepository;

    public Person delete(Long id){
        Person person = fetch(id);
        if(person == null){
            return null;
        }
        personRepository.delete(person);
        return person;
    }

    public List<Person> fetchAll() {
        return personRepository.findAll();
    }

    public Person fetch(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);

        if(!optionalPerson.isPresent()){
            return null;
        }

        return optionalPerson.get();
    }

    public Person save(PersonCommand personCommand) {
        Person person = null;

        // repository have id
        if (personCommand.getId() != null) {
            Optional<Person> optionalPerson = personRepository.findById(personCommand.getId());
            if (optionalPerson.isPresent()) {
                person = optionalPerson.get();
                person.setName(personCommand.getName());
                person.setSurename(personCommand.getSurename());
            } else
                return null;
        } else {
            person = new Person(personCommand.getName(), personCommand.getSurename());
        }

        return personRepository.save(person);
    }
}
