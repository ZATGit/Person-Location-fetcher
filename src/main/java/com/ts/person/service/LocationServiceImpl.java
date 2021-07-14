package com.ts.person.service;

import static com.ts.person.utils.UtilConstants.ZIP_API_URL;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.ts.person.model.Person;

@Service
public class LocationServiceImpl implements LocationService {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    public List<Person> fetchPersonResponse(List<Person> personList) throws IOException, InterruptedException {
        List<Person> responseList = createLocationRequest(personList);
        return responseList;
    }

    public List<Person> createLocationRequest(List<Person> personList) throws IOException, InterruptedException {
        logger.info("Create Ziptastic Request");
        String zipUrlPath;
        List<Person> responseList = new ArrayList<>();

        for (Person person: personList) {
            zipUrlPath = ZIP_API_URL.concat(person.getZipcode());
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(zipUrlPath))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            mapResponse(responseList, person, response);
        }
        return responseList;
    }

    private void mapResponse(List<Person> responseList, Person person,
                             HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Person personJson = om.readValue(response.body(), Person.class);
        personJson.setId(person.getId());
        personJson.setFirstName(person.getFirstName());
        personJson.setLastName(person.getLastName());
        personJson.setEmail(person.getEmail());
        personJson.setZipcode(person.getZipcode());
        responseList.add(personJson);
    }
}
