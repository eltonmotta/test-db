package com.example.testdb.service;

import com.example.testdb.entity.Person;
import com.example.testdb.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository repositoryMock;

    @InjectMocks
    private PersonService personService;

    @Test
    public void create() {
        //given
        Person person1 = Person.builder()
                .name("Elton")
                .dob(new Date()).build();

        Person personResult = Person.builder()
                .id(1)
                .name("Elton")
                .dob(new Date()).build();

        Mockito.when(repositoryMock.save(person1)).thenReturn(personResult);

        //when
        Person result = personService.create(person1);

        //then
        assertThat(result)
                .isNotNull()
                .isEqualToComparingFieldByField(personResult);
        Mockito.verify(repositoryMock, Mockito.times(1)).save(person1);

    }

    @Test
    public void getAllPersons() {
    }
}