package com.raven.personapp.domain.service;

import lombok.NoArgsConstructor;

public class PersonAction {

    public PersonTalk personTalk;

    public PersonAction(PersonTalk personTalk) {
        this.personTalk = personTalk;
    }

    public void hablar(){
        System.out.println(personTalk.saludo());
    }


}
