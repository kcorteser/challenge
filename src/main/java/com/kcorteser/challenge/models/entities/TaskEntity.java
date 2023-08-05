package com.kcorteser.challenge.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="task")
public class TaskEntity {
    public TaskEntity(String name, String description, Date expirationDate, Boolean isComplete) {
        this.name = name;
        this.description = description;
        this.expirationDate = expirationDate;
        this.isComplete = isComplete;
    }
    public TaskEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Date expirationDate;
    private Boolean isComplete;


}
