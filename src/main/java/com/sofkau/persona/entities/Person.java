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
    @Column(name = "id", nullable = false)
    @NotNull(message = "El id no puede ser null")
    private Integer id;
    private String name;
    private String age;
}
