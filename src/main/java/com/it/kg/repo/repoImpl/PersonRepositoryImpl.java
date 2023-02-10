package com.it.kg.repo.repoImpl;

import com.it.kg.configuration.HibernateUtil;
import com.it.kg.models.Person;
import com.it.kg.repo.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.save(person);
        }
    }

    @Override
    public Person getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Person.class, id);
        }
    }

    @Override
    public List findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select p from Person p").getResultList();
        }
    }

    @Override
    public void updateById(Long id, Person newPerson) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person p = getById(id);
            p.setFname(newPerson.getFname());
            p.setLname(newPerson.getLname());
            p.setAge(newPerson.getAge());
            p.setGender(newPerson.getGender());
            p.setEmail(newPerson.getEmail());
            p.setPhones(newPerson.getPhones());
            session.saveOrUpdate(p);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = getById(id);
            session.delete(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public void clear() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Person p").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
