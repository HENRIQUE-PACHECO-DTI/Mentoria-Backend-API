package io.github.henriqueaguiiar.rinhaDeBackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


/**
 * Entidade Person
 * @author Henrique Pacheo
 * @version 1.1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "tb_person")
public class Person implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "surName")
    private String surName;
    @Column(name = "name")
    private String name;
    @Column(name = "bornDate")
    private String bornDate;
    @Column(name = "stack")
    @ElementCollection
    private List<String> stack;


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", stack=" + stack +
                '}';
    }
}
