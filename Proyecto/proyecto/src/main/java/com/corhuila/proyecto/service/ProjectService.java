package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.ProjectDTO;
import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {

    Response<List<ProjectEntity>> getAllProjects();

    Response<ProjectEntity> getProjectById(Long id);

    Response<ProjectEntity> saveProject(ProjectDTO request);

    Response<ProjectEntity> updateProject(ProjectDTO request);

    Response<ProjectEntity> deleteLogicProject(Long id);

    Response<String> deleteProject(Long id);

}
