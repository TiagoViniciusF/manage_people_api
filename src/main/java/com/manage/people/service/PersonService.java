package com.manage.people.service;

import com.manage.people.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person save(Person person);

    Optional<Person> findById(Long personId);

    List<Person> findAll();

    void delete(Person person);
}
