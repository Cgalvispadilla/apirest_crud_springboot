package com.sofkau.persona.services;

import com.sofkau.persona.entities.Person;
import com.sofkau.persona.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements InterfaceServicesPerson {

    @Autowired
    private PersonRepository data;

    @Override
    public Person save(Person persona) {
        return data.save(persona);
    }

    @Override
    public List<Person> list() {
        return data.findAll();
    }

    @Override
    public Person listById(int id) {
        return data.getById(id);
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

    @Override
    public Person update(Person persona, int id) {
        return  data.findById(id)
                .map(person -> {
                    person.setId(persona.getId());
                    person.setName(persona.getName());
                    person.setAge(persona.getAge());
                    return data.save(person);
                }).get();
    }
}
