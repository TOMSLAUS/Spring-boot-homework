package com.homework.Beans.ModelMapper;

import com.homework.Enums.Gender;
import org.modelmapper.AbstractConverter;

public class PersonGenderToPersonDto extends AbstractConverter<Gender, String> {

    @Override
    protected String convert(Gender gender) {
        String stringGender = gender.toString();
        return stringGender.substring(0, 1).toUpperCase() + stringGender.substring(1).toLowerCase();
    }
}