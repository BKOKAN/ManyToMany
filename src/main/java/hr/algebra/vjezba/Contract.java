package hr.algebra.vjezba;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private Double salary;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Contract() {
    }

    public Contract(LocalDate startDate, Double salary, Person person, Company company) {
        this.startDate = startDate;
        this.salary = salary;
        this.person = person;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Person getPerson() {
        return person;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setId(Long id) {
        this.id = id;
    }
}