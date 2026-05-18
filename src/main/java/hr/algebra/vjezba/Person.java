package hr.algebra.vjezba;

import jakarta.persistence.*;
import java.util.*;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "person")
    private Set<Contract> contracts = new HashSet<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
