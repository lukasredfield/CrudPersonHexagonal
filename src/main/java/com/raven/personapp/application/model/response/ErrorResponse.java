package com.raven.personapp.application.model.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private int code;
    private String cause;
}
