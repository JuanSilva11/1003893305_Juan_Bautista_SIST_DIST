package com.corhuila.proyecto.implement;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.UserDTO;
import com.corhuila.proyecto.dto.UserProjectDTO;
import com.corhuila.proyecto.entity.UserEntity;
import com.corhuila.proyecto.entity.UserProjectEntity;
import com.corhuila.proyecto.repository.UserProjectRepository;
import com.corhuila.proyecto.service.UserProjectService;
import com.corhuila.proyecto.utils.Constants;
import com.corhuila.proyecto.utils.GenericServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProjectServiceImpl implements UserProjectService {

    private final UserProjectRepository userProjectRepository;

    @Override
    public Response<List<UserProjectEntity>> getAllUserProjects() {
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), userProjectRepository.findAll());
    }

    @Override
    public Response<UserProjectEntity> getUserProjectById(Long id) {
        Optional<UserProjectEntity> userProject = userProjectRepository.findById(id);
        if (userProject.isEmpty()) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_02.getCode(), Constants.RESPONSE_CODE_02.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), userProject.get());
    }

    @Override
    public Response<UserProjectEntity> saveUserProject(Map<String, Integer> request) {
        if (request.containsKey("idProyecto") && request.containsKey("idUsuario")) {
            UserProjectEntity userProject = UserProjectEntity.builder()
                    .projectId(Long.valueOf(request.get("idProyecto")))
                    .userId(Long.valueOf(request.get("idUsuario")))
                    .build();
            try {
                userProjectRepository.save(userProject);
            } catch (DataIntegrityViolationException e) {
                log.error("Ha ocurrido un error al guardar la asociación proyecto usuario: {}", e.getMessage());
                return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
            }
            userProject = getUserProjectById(userProject.getId()).getData();
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), userProject);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_06.getCode(), Constants.RESPONSE_CODE_06.getMessage(), null);
    }

    @Override
    public Response<String> deleteUserProject(Long id) {
        Response<UserProjectEntity> userProject = getUserProjectById(id);
        if (!Objects.equals(userProject.getResponseCode(), 1) && Objects.isNull(userProject.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_05.getCode(), Constants.RESPONSE_CODE_05.getMessage(), null);
        }
        userProjectRepository.deleteById(id);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), "Se ha eliminado la asociación proyecto usuario");
    }

    @Override
    public Response<?> filterUsersByProject(Long idProject) {
        List<UserProjectEntity> userProjects = userProjectRepository.findByProjectId(idProject);
        if (userProjects.isEmpty()) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), "No se encontraron usuarios asociados a proyectos");
        }
        List<UserEntity> listEntityUsers = new ArrayList<>();
        userProjects.forEach(userProject -> listEntityUsers.add(userProject.getUser()));
        List<UserDTO> listUsers = new ArrayList<>();
        listEntityUsers.forEach(user -> {
            listUsers.add(
                    UserDTO.builder()
                            .id(user.getId())
                            .documentType(user.getDocumentType())
                            .documentNumber(user.getDocumentNumber())
                            .names(user.getNames())
                            .surnames(user.getSurnames())
                            .build()
            );
        });

        UserProjectDTO userProject = new UserProjectDTO();
        userProject.setId(idProject);
        userProject.setName(userProjects.get(0).getProject().getName());
        userProject.setDescription(userProjects.get(0).getProject().getDescription());
        userProject.setStartDate(userProjects.get(0).getProject().getStartDate());
        userProject.setEndDate(userProjects.get(0).getProject().getEndDate());
        userProject.setUsers(listUsers);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), userProject);
    }

    @Override
    public Response<?> filterProjectsByUser(Long idUser) {
        return null;
    }

}
