package hr.algebra.vjezba;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "company", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Contract> contracts = new HashSet<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}