package com.raven.personapp.domain.service;

public class PersonTalkImp implements PersonTalk{

    @Override
    public String saludo() {
        return "Hola, como estas?";
    }

    @Override
    public String despedida() {
        return "Adios, nos vemos!";
    }

    @Override
    public String bendecir() {
        return "Dios te bendiga!";
    }

}
