package com.ts.person.service;

import java.io.IOException;
import java.util.List;

import com.ts.person.model.Person;

public interface PersonService {
    List<Person> getAllPersonsAsc() throws IOException, InterruptedException;
}
