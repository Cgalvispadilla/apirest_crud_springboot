package com.sofkau.persona.services;

import com.sofkau.persona.entities.Person;
import com.sofkau.persona.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonService implements InterfaceServicesPerson {

    @Autowired
    private PersonRepository data;

    @Override
    public Person save(Person persona) {
        Person personAux= persona;
        if(personAux.getId()==null){
            throw new DuplicateKeyException("El id no puede estar vacio");
        }
        if(data.exists(Example.of(personAux))){
            throw new DuplicateKeyException("Ya existe el usario con id: "+persona.getId());
        }
        return data.save(persona);
    }

    @Override
    public List<Person> list() {
        return data.findAll();
    }

    @Override
    public Person listById(int id) {
        Optional<Person> opt = data.findById(id);
        if(opt.isEmpty()){
            throw new NoSuchElementException("No existe ningun usario con id "+id);
        }
        return opt.get();
    }

    @Override
    public void delete(int id) {
        Optional<Person> opt = data.findById(id);
        if(opt.isEmpty()){
            throw new NoSuchElementException("No existe ningun usario con id "+id);
        }
        data.deleteById(id);
    }

    @Override
    public Person update(Person persona, int id) {
        Optional<Person> opt = data.findById(id);
        if(opt.isEmpty()){
            throw new NoSuchElementException("No se puede editar puesto que existe ningun usario con id "+id);
        }
        return  opt
                .map(person -> {
                    person.setId(persona.getId());
                    person.setName(persona.getName());
                    person.setAge(persona.getAge());
                    return data.save(person);
                }).get();
    }
}
