package com.ts.person.jpa;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ts.person.model.Person;

@Transactional(readOnly = true)
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll(Sort lastName);
}
