package com.homework.Person;

import org.springframework.stereotype.Service;
import java.text.ParseException;

@Service
public interface PersonService {
    PersonDto getPersons(String personalId, String dob) throws ParseException;
}
