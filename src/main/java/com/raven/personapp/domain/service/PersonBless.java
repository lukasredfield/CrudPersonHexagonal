package com.raven.personapp.domain.service;

public class PersonBless {

    private PersonTalk personTalk;

    public PersonBless(PersonTalk personTalk) {
        this.personTalk = personTalk;
    }

    public void iluminar(){
        System.out.println(personTalk.bendecir());
    }

}
