package com.homework.Beans;

import com.homework.Beans.ModelMapper.PersonDobToPersonDtoDob;
import com.homework.Beans.ModelMapper.PersonGenderToPersonDto;
import com.homework.Person.Person;
import com.homework.Person.PersonDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Person, PersonDto> personTypeMap = modelMapper.createTypeMap(Person.class, PersonDto.class);

        personTypeMap.addMappings(new PropertyMap<Person, PersonDto>() {
            @Override
            protected void configure() {
                using(new PersonDobToPersonDtoDob()).map(source.getDob(), destination.getDob());
            }
        });

        personTypeMap.addMappings(new PropertyMap<Person, PersonDto>() {
            @Override
            protected void configure() {
                using(new PersonGenderToPersonDto()).map(source.getGender(), destination.getGender());
            }
        });

        return modelMapper;
    }
}
