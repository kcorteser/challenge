package com.kcorteser.challenge.controllers.inputDTO;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDTO {
    private String name;
    private String description;
    private Date expirationDate;
    private Boolean isComplete;

}
