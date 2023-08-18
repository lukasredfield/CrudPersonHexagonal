package com.raven.personapp.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private int age;
}
