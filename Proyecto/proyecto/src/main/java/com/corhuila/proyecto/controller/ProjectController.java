package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.ProjectDTO;
import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.ProjectEntity;
import com.corhuila.proyecto.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/proyectos")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/listar")
    public Response<List<ProjectEntity>> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/buscar/{id}")
    public Response<ProjectEntity> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/agregar")
    public Response<ProjectEntity> saveProject(@RequestBody ProjectDTO request) {
        return projectService.saveProject(request);
    }

    @PutMapping("/actualizar")
    public Response<ProjectEntity> updateProject(@RequestBody ProjectDTO request) {
        return projectService.updateProject(request);
    }

    @PutMapping("/eliminar/{id}")
    public Response<ProjectEntity> deleteLogicProject(@PathVariable Long id) {
        return projectService.deleteLogicProject(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public Response<String> deleteProject(@PathVariable Long id) {
        return projectService.deleteProject(id);
    }

}