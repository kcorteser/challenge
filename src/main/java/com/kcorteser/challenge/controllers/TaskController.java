package com.kcorteser.challenge.controllers;


import com.kcorteser.challenge.controllers.inputDTO.CreateTaskDTO;
import com.kcorteser.challenge.controllers.inputDTO.UpdateStatusDTO;
import com.kcorteser.challenge.models.DTO.TaskDTO;
import com.kcorteser.challenge.services.implementations.TaskServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@Tag(name = "TaskController", description = "Controlador para las operaciones crud sobre las tareas.")
@RequestMapping("/task")
public class TaskController {
    static Logger log = LogManager.getLogger(TaskController.class);
    private final TaskServiceImp taskService;

    @Autowired
    public TaskController(TaskServiceImp taskService) {
        this.taskService = taskService;
    }
    @Operation(summary = "Obtener todos las tareas", description = "Obtiene una lista de todas las tareas")
    @GetMapping()
    public ResponseEntity<List<TaskDTO>> getAll() {
        try {
            return ResponseEntity.ok(taskService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Crea una tarea", description = "Crea una tarea")
    @PostMapping()
    public ResponseEntity<String> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        try {
            taskService.createTask(createTaskDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Elimina una tarea", description = "Elimina una tarea")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Actualiza una tarea", description = "Actualiza una tarea")
    @PutMapping()
    public ResponseEntity<String> updateTask(@RequestBody UpdateStatusDTO updateStatusDTO) {
        try {
            taskService.updateStatusTask(updateStatusDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}