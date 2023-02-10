package com.it.kg;

import com.it.kg.models.Person;
import com.it.kg.models.Phone;
import com.it.kg.repo.repoImpl.PersonRepositoryImpl;
import com.it.kg.repo.repoImpl.PhoneRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Person person = new Person("Marlen", "Temirbaev", 17, 'm', "mtemirbaev86@gmail.com");

        Phone phone = new Phone("POCO X3 NFC", "White", 30000);
        Phone phone1 = new Phone("Redmi 8", "Blue", 15000);

        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        phones.add(phone1);
        person.setPhones(phones);
        phone.setPerson(person);
        phone1.setPerson(person);

        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        PhoneRepositoryImpl phoneRepository = new PhoneRepositoryImpl();

//        personRepository.save(person);

//        phoneRepository.deleteById(8L);
//        System.out.println(personRepository.getById(1L));
//        System.out.println(phoneRepository.findAll());
//        System.out.println(personRepository.getById(2L));
//        System.out.println(personRepository.findAll());
    }
}