package com.homework.Person;

import com.homework.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@With
@AllArgsConstructor
public class Person {


    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    //Šis ļauj mysql datubāzē glabāt UUID kā string value
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    private UUID id;

    @Column
    private String personalId;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private Date dob;

    public Person() {
    }
}
