package hr.algebra.vjezba;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("library");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p1 = new Person("Ivan");
        Person p2 = new Person("Ana");

        Company c1 = new Company("Google");
        Company c2 = new Company("Microsoft");

        em.persist(p1);
        em.persist(p2);
        em.persist(c1);
        em.persist(c2);

        Contract ugovor1 =
                new Contract(LocalDate.now(), 2500.0, p1, c1);

        Contract ugovor2 =
                new Contract(LocalDate.now(), 3000.0, p2, c2);

        em.persist(ugovor1);
        em.persist(ugovor2);

        p1.setName("Ivan Horvat");

        em.remove(ugovor2);

        em.getTransaction().commit();

        List<Person> persons = em.createQuery("from Person", Person.class).getResultList();

        for (Person p : persons) {
            System.out.println(p.getName());
        }

        List<Contract> contracts = em.createQuery("from Contract", Contract.class).getResultList();
        for (Contract c : contracts){
            System.out.println((c.getSalary()));
            System.out.println(c.getStartDate());
            System.out.println(c.getPerson().getName());
            System.out.println(c.getCompany().getName());
            System.out.println(c.getId());
        }

        em.close();
        emf.close();
    }
}