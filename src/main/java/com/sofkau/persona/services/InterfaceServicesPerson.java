package com.sofkau.persona.services;

import com.sofkau.persona.entities.Person;

import java.util.List;

public interface InterfaceServicesPerson {
    public Person save(Person persona);
    public List<Person> list();
    public  Person listById(int id);
    public void delete(int id);
    public Person update(Person persona, int id);
}
