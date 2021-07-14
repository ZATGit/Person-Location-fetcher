package com.ts.person.service;

import java.io.IOException;
import java.util.List;

import com.ts.person.model.Person;

public interface LocationService {
    List<Person> createLocationRequest(List<Person> personList) throws IOException, InterruptedException;
    List<Person> fetchPersonResponse(List<Person> result) throws IOException, InterruptedException;
}

