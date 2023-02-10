package com.it.kg.repo;

import com.it.kg.models.Phone;

import java.util.List;

public interface PhoneRepository {

    void save(Phone phone);

    Phone getById(Long id);

    List<Phone> findAll();

    void updateById(Long id, Phone phone);

    void deleteById(Long id);

    void clear();
}
