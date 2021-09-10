package com.sofkau.persona.controllers;

import com.sofkau.persona.entities.Person;
import com.sofkau.persona.services.InterfaceServicesPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/personas")
@RestController
public class PersonRestController {
    @Autowired
    private InterfaceServicesPerson services;

    @GetMapping(value = "/listar")
    public Iterable<Person> listAll(){
        return services.list();
    }



}
