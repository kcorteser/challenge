package com.kcorteser.challenge.services.implementations;

import com.kcorteser.challenge.controllers.inputDTO.CreateTaskDTO;
import com.kcorteser.challenge.controllers.inputDTO.UpdateStatusDTO;
import com.kcorteser.challenge.models.DTO.TaskDTO;
import com.kcorteser.challenge.models.entities.TaskEntity;
import com.kcorteser.challenge.models.mappers.TaskMapper;
import com.kcorteser.challenge.repositories.TaskRepository;
import com.kcorteser.challenge.services.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<TaskDTO> findAll() {
        List<TaskEntity> taskList = taskRepository.findAll();
        return TaskMapper.INSTANCE
                .taskEntitiesToDtos(taskList);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateStatusTask(UpdateStatusDTO updateStatusDTO) {
        Optional<TaskEntity> taskOptional = taskRepository.findById(updateStatusDTO.getId());
        if(taskOptional.isEmpty()){
            throw new RuntimeException();
        }
        TaskEntity task = taskOptional.get();
        task.setIsComplete(updateStatusDTO.getIsComplete());
        taskRepository.save(task);
    }

    @Override
    public void createTask(CreateTaskDTO createTaskDTO) {
        TaskEntity task = new TaskEntity(createTaskDTO.getName(), createTaskDTO.getDescription(),createTaskDTO.getExpirationDate(),createTaskDTO.getIsComplete());
        taskRepository.save(task);
    }


}
