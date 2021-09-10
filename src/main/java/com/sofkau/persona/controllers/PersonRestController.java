package com.sofkau.persona.controllers;

import com.sofkau.persona.entities.Person;
import com.sofkau.persona.services.InterfaceServicesPerson;
import com.sofkau.persona.utils.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/persona")
@RestController
public class PersonRestController {
    @Autowired
    private InterfaceServicesPerson services;

    @GetMapping(value = "/listar")
    public Iterable<Person> listAll() {
        return services.list();
    }

    @PostMapping(value = "/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@Valid @RequestBody Person person, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return services.save(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<Person> deletePerson(@PathVariable int id) {
        services.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/editar/{id}")
    ResponseEntity<Person> editPerson(@RequestBody Person person, @PathVariable int id) {
        return new ResponseEntity(services.update(person, id), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public Person listOnePerson(@PathVariable int id) {
        return services.listById(id);
    }
}
