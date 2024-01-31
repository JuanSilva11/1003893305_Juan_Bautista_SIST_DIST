package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.UserProjectEntity;

import java.util.List;
import java.util.Map;

public interface UserProjectService {

    Response<List<UserProjectEntity>> getAllUserProjects();

    Response<UserProjectEntity> getUserProjectById(Long id);

    Response<UserProjectEntity> saveUserProject(Map<String, Integer> request);

    Response<String> deleteUserProject(Long id);

    Response<?> filterUsersByProject(Long idProject);

    Response<?> filterProjectsByUser(Long idUser);

}
