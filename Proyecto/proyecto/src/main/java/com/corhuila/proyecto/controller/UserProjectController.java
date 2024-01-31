package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.UserProjectEntity;
import com.corhuila.proyecto.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/usuario-proyecto")
public class UserProjectController {

    @Autowired
    private UserProjectService userProjectService;

    @GetMapping("/listar")
    public Response<List<UserProjectEntity>> getAllUserProjects() {
        return userProjectService.getAllUserProjects();
    }

    @GetMapping("/buscar/{id}")
    public Response<UserProjectEntity> getUserProjectById(@PathVariable Long id) {
        return userProjectService.getUserProjectById(id);
    }

    @PostMapping("/agregar")
    public Response<UserProjectEntity> saveUserProject(@RequestBody Map<String, Integer> request) {
        return userProjectService.saveUserProject(request);
    }

    @DeleteMapping("/eliminar/{id}")
    public Response<String> deleteUserProject(@PathVariable Long id) {
        return userProjectService.deleteUserProject(id);
    }

    @GetMapping("/filtrarUsuarios/{id}")
    public Response<?> filterUsersByProject(@PathVariable Long id) {
        return userProjectService.filterUsersByProject(id);
    }

    @GetMapping("/filtrarProyectos/{id}")
    public Response<?> filterProjectsByUser(@PathVariable Long id) {
        return userProjectService.filterProjectsByUser(id);
    }

}
