package com.kcorteser.challenge.models.DTO;


import lombok.Data;

import java.util.Date;
@Data
public class TaskDTO {

    private Integer id;
    private String name;
    private String description;
    private Date expirationDate;
    private Boolean isComplete;

}