package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.TaskDTO;
import com.corhuila.proyecto.entity.TaskEntity;
import com.corhuila.proyecto.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/tareas")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/listar")
    public Response<List<TaskEntity>> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/buscar/{id}")
    public Response<TaskEntity> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/agregar")
    public Response<TaskEntity> saveTask(@RequestBody TaskDTO request) {
        return taskService.saveTask(request);
    }

    @PutMapping("/actualizar")
    public Response<TaskEntity> updateTask(@RequestBody TaskDTO request) {
        return taskService.updateTask(request);
    }

    @PutMapping("/eliminar/{id}")
    public Response<TaskEntity> deleteLogicTask(@PathVariable Long id) {
        return taskService.deleteLogicTask(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public Response<String> deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

}
