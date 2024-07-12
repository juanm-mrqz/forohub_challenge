package com.alura.forohub.model.response;

import com.alura.forohub.model.users.UserDto;

import java.time.LocalDateTime;

public record ResponseData (

    String message,

    UserDto user,
    Boolean solution,
    LocalDateTime createdAt
){
    public ResponseData(Response response) {
        this(response.getMessage(),
             new UserDto(response.getUser()),
             response.getSolution(),
             LocalDateTime.now()
        );
    }
}

