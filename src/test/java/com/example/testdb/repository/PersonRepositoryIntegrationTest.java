package com.example.testdb.repository;

import com.example.testdb.entity.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testFindById() {
        //given
        Person person1 = Person.builder().name("Test1").dob(new Date()).build();
        entityManager.persist(person1);
        entityManager.flush();;

        //when
        Person result = personRepository.findById(1).orElse(null);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Test1");

    }

}