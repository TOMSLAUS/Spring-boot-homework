package com.homework.PersonTests.UnitTests;


import com.homework.Exceptions.CustomExceptions;
import com.homework.Person.*;
import com.homework.utils.DateUtils;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
public class PersonUnitTests {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonController personController;

    @Mock
    PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void contextLoad(){}


    @Test
    public void testIfMissingParametersThrown() throws ParseException {
        String id = "";
        String date = "01-01-2023";
        when(personRepository.findByPersonalIdAndDob(id, DateUtils.formatDate(date))).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            personController.getPersons(id,date);
        });

        assertTrue(exception.getMessage().contains(CustomExceptions.MISSING_PARAMETERS.toString()));    }

    @Test
    public void testIfUserDoesntExistThrown() throws ParseException {
        String id = "123";
        String date = "01-01-2023";
        when(personRepository.findByPersonalIdAndDob(id, DateUtils.formatDate(date))).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            personService.getPersons(id,date);
        });

        assertTrue(exception.getMessage().contains(CustomExceptions.USER_DOESNT_EXIST.toString()));    }


}
