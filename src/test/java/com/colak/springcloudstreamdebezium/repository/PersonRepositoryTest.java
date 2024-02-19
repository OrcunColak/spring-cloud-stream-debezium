package com.colak.springcloudstreamdebezium.repository;

import com.colak.springcloudstreamdebezium.jpa.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
// no rollback
@Transactional(propagation = Propagation.NOT_SUPPORTED)

// use actual database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void testSave() {

        Person person = new Person(null, "firstname", "lastname");
        Person savedPerson = repository.save(person);

        Assertions.assertNotNull(savedPerson.getId());

    }
}
