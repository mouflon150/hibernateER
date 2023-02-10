package com.it.kg.repo;

import com.it.kg.models.Person;

import java.util.List;

public interface PersonRepository {

    void save(Person person);

    Person getById(Long id);

    List<Person> findAll();

    void updateById(Long id, Person person);

    void deleteById(Long id);

    void clear();
}
