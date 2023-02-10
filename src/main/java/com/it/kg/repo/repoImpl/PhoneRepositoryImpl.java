package com.it.kg.repo.repoImpl;

import com.it.kg.configuration.HibernateUtil;
import com.it.kg.models.Phone;
import com.it.kg.repo.PhoneRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PhoneRepositoryImpl implements PhoneRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Phone phone) {
        try (Session session = sessionFactory.openSession()) {
            session.save(phone);
        }
    }

    @Override
    public Phone getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Phone.class, id);
        }
    }

    @Override
    public List findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select p from Phone p").getResultList();
        }
    }

    @Override
    public void updateById(Long id, Phone newPhone) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Phone p = getById(id);
            p.setModel(newPhone.getModel());
            p.setColor(newPhone.getColor());
            p.setPrice(newPhone.getPrice());
            session.beginTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                Phone p = getById(id);
                session.delete(p);
                session.getTransaction().commit();
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void clear() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Phone p").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
