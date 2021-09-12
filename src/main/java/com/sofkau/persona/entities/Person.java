package com.sofkau.persona.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false)
    @NotNull(message = "Para guardar una persona necesita el nombre")
    private String name;
    @Column(name = "age", nullable = false)
    @NotNull(message = "Para guardar una persona necesita la edad")
    private String age;
}
