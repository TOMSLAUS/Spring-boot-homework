package com.homework.Person;

import com.homework.Exceptions.CustomExceptions;
import com.homework.Exceptions.HttpBadRequestException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public PersonDto getPersons(String personalId, String dob) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dob);
        Optional<Person> person = personRepository.findByPersonalIdAndDob(personalId, date);
        if (person.isEmpty()) {
            throw new HttpBadRequestException(CustomExceptions.USER_DOESNT_EXIST.toString());
        }
        PersonDto personDto = modelMapper.map(person.get(), PersonDto.class);
        return personDto;
    }
}
