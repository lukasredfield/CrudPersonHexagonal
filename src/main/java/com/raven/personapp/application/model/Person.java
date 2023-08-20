package com.raven.personapp.application.model;

import lombok.Data;

@Data
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private int age;

}
