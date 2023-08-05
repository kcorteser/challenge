package com.kcorteser.challenge.services.interfaces;

import com.kcorteser.challenge.controllers.inputDTO.CreateTaskDTO;
import com.kcorteser.challenge.controllers.inputDTO.UpdateStatusDTO;
import com.kcorteser.challenge.models.DTO.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> findAll();
    void deleteTask(Integer id);
    void updateStatusTask(UpdateStatusDTO updateStatusDTO);

    void createTask (CreateTaskDTO createTaskDTO);
}
