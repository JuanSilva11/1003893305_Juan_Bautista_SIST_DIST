package com.corhuila.proyecto.implement;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.TaskDTO;
import com.corhuila.proyecto.entity.TaskEntity;
import com.corhuila.proyecto.repository.TaskRepository;
import com.corhuila.proyecto.service.TaskService;
import com.corhuila.proyecto.utils.Constants;
import com.corhuila.proyecto.utils.GenericServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Response<List<TaskEntity>> getAllTasks() {
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), taskRepository.findAll());
    }

    @Override
    public Response<TaskEntity> getTaskById(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_02.getCode(), Constants.RESPONSE_CODE_02.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), task.get());
    }

    @Override
    public Response<TaskEntity> saveTask(TaskDTO request) {
        TaskEntity task = TaskEntity.builder()
                .history(request.getHistory())
                .description(request.getDescription())
                .acceptanceCriteria(request.getAcceptanceCriteria())
                .projectId(request.getProjectId())
                .build();
        task.setState(true);
        task.setCreatedAt(LocalDateTime.now());
        try {
            taskRepository.save(task);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al registrar una tarea: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        task = getTaskById(task.getId()).getData();
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), task);
    }

    @Override
    public Response<TaskEntity> updateTask(TaskDTO request) {
        Response<TaskEntity> updateTask = getTaskById(request.getId());
        if (!Objects.equals(updateTask.getResponseCode(), 1) && Objects.isNull(updateTask.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_04.getCode(), Constants.RESPONSE_CODE_04.getMessage(), null);
        }
        TaskEntity task = updateTask.getData();
        task.setHistory(request.getHistory());
        task.setDescription(request.getDescription());
        task.setAcceptanceCriteria(request.getAcceptanceCriteria());
        task.setProjectId(request.getProjectId());
        task.setUpdatedAt(LocalDateTime.now());
        try {
            taskRepository.save(task);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al actualizar una tarea: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), task);
    }

    @Override
    public Response<TaskEntity> deleteLogicTask(Long id) {
        Response<TaskEntity> updateTask = getTaskById(id);
        if (!Objects.equals(updateTask.getResponseCode(), 1) && Objects.isNull(updateTask.getData())) {
            return GenericServices.buildResponse(updateTask.getResponseCode(), updateTask.getResponseMessage(), null);
        }
        TaskEntity task = updateTask.getData();
        task.setState(false);
        task.setDeletedAt(LocalDateTime.now());
        taskRepository.save(task);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), task);
    }

    @Override
    public Response<String> deleteTask(Long id) {
        Response<TaskEntity> deleteTask = getTaskById(id);
        if (!Objects.equals(deleteTask.getResponseCode(), 1) && Objects.isNull(deleteTask.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_05.getCode(), Constants.RESPONSE_CODE_05.getMessage(), null);
        }
        taskRepository.deleteById(id);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), "Tarea eliminada correctamente");
    }
}
