package com.ts.person.rest;

import static com.ts.person.utils.UtilConstants.PERSON_API_ENDPOINT;
import static com.ts.person.utils.UtilConstants.API_VERSION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.ts.person.exception.UniqueConstraintException;
import com.ts.person.exception.ZipCodeNotFoundException;
import com.ts.person.jpa.PersonRepository;
import com.ts.person.model.Person;
import com.ts.person.service.LocationService;
import com.ts.person.service.PersonService;

@RestController
@RequestMapping(PERSON_API_ENDPOINT)
public class PersonController {

    @Autowired
    public PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private final LocationService locationService;

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    public PersonController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE + API_VERSION)
    @ResponseBody
    public Iterable<Person> getPerson() throws IOException, InterruptedException {
        logger.info("Get all people");
        try {
            List<Person> personList = personService.getAllPersonsAsc();
            return locationService.fetchPersonResponse(personList);
        } catch (JsonParseException exception) {
            throw new ZipCodeNotFoundException();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) throws DataIntegrityViolationException {
        logger.info("Create person");
        try {
            return personRepository.save(person);
        } catch (DataIntegrityViolationException exception) {
            throw new UniqueConstraintException();
        }
    }
}
