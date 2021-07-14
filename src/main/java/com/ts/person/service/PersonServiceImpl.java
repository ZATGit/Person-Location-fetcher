package com.ts.person.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.ts.person.jpa.PersonRepository;
import com.ts.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    private Person person;
    private LocationService locationService;

    public List<Person> getAllPersonsAsc() throws IOException, InterruptedException {
        List<Person> personList = personRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
        return personList;
    }
}
