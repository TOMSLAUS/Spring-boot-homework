package com.homework.Beans.ModelMapper;

import org.modelmapper.AbstractConverter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonDobToPersonDtoDob extends AbstractConverter<Date, String> {

    @Override
    protected String convert(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }
}
