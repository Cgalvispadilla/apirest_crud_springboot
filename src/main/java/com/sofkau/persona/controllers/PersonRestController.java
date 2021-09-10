package com.sofkau.persona.controllers;

import com.sofkau.persona.entities.Person;
import com.sofkau.persona.services.InterfaceServicesPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/persona")
@RestController
public class PersonRestController {
    @Autowired
    private InterfaceServicesPerson services;

    @GetMapping(value = "/listar")
    public Iterable<Person> listAll(){
        return services.list();
    }

    @PostMapping(value = "/agregar")
    ResponseEntity<Person> addPerson(@RequestBody Person person){
        return new ResponseEntity<>(services.save(person), HttpStatus.CREATED);
    }


}
