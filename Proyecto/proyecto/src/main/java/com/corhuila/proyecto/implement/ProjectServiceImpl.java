package com.corhuila.proyecto.implement;

import com.corhuila.proyecto.dto.ProjectDTO;
import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.ProjectEntity;
import com.corhuila.proyecto.repository.ProjectRepository;
import com.corhuila.proyecto.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Response<List<ProjectEntity>> getAllProjects() {
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), projectRepository.findAll());
    }

    @Override
    public Response<ProjectEntity> getProjectById(Long id) {
        Optional<ProjectEntity> project = projectRepository.findById(id);
        if (project.isEmpty()) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_02.getCode(), Constants.RESPONSE_CODE_02.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), project.get());
    }

    @Override
    public Response<ProjectEntity> saveProject(ProjectDTO request) {
        ProjectEntity project = ProjectEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
        project.setState(true);
        project.setCreatedAt(LocalDateTime.now());
        try {
            projectRepository.save(project);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al guardar el proyecto: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), project);
    }

    @Override
    public Response<ProjectEntity> updateProject(ProjectDTO request) {
        Response<ProjectEntity> updateProject = getProjectById(request.getId());
        if (!Objects.equals(updateProject.getResponseCode(), 1) && Objects.isNull(updateProject.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_04.getCode(), Constants.RESPONSE_CODE_04.getMessage(), null);
        }
        ProjectEntity project = updateProject.getData();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setStartDate(request.getStartDate());
        project.setEndDate(request.getEndDate());
        project.setUpdatedAt(LocalDateTime.now());
        try {
            projectRepository.save(project);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al actualizar el proyecto: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), project);
    }

    @Override
    public Response<ProjectEntity> deleteLogicProject(Long id) {
        Response<ProjectEntity> updateProject = getProjectById(id);
        if (!Objects.equals(updateProject.getResponseCode(), 1) && Objects.isNull(updateProject.getData())) {
            return GenericServices.buildResponse(updateProject.getResponseCode(), updateProject.getResponseMessage(), null);
        }
        ProjectEntity project = updateProject.getData();
        project.setState(false);
        project.setDeletedAt(LocalDateTime.now());
        projectRepository.save(project);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), project);
    }

    @Override
    public Response<String> deleteProject(Long id) {
        Response<ProjectEntity> deleteProject = getProjectById(id);
        if (!Objects.equals(deleteProject.getResponseCode(), 1) && Objects.isNull(deleteProject.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_05.getCode(), Constants.RESPONSE_CODE_05.getMessage(), null);
        }
        projectRepository.deleteById(id);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), "Proyecto eliminado correctamente");
    }
}
