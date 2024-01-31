package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.TaskDTO;
import com.corhuila.proyecto.entity.TaskEntity;

import java.util.List;

public interface TaskService {

    Response<List<TaskEntity>> getAllTasks();

    Response<TaskEntity> getTaskById(Long id);

    Response<TaskEntity> saveTask(TaskDTO request);

    Response<TaskEntity> updateTask(TaskDTO request);

    Response<TaskEntity> deleteLogicTask(Long id);

    Response<String> deleteTask(Long id);
    
}
