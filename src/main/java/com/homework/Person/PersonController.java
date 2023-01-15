package com.homework.Person;


import com.homework.Exceptions.CustomExceptions;
import com.homework.Exceptions.HttpBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    Logger log = LoggerFactory.getLogger(PersonController.class);

    @GetMapping(value = "/getPersons")
    public PersonDto getPersons(@RequestParam String personalId, @RequestParam String dob) throws ParseException {

        log.info("Getting person with personal ID: {} and dob: {}", personalId, dob);

        if (personalId.isEmpty() || dob.isEmpty()) {
            log.error("Missing parameters");
            throw new HttpBadRequestException(CustomExceptions.MISSING_PARAMETERS.toString());
        }

        return personService.getPersons(personalId, dob);
    }
}
