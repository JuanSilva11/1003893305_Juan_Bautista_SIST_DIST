package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.FollowUpDTO;
import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.FollowUpEntity;
import com.corhuila.proyecto.service.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/seguimiento")
public class FollowUpController {

    @Autowired
    private FollowUpService followUpService;

    @GetMapping("/listar")
    public Response<List<FollowUpEntity>> getAllFollowUps() {
        return followUpService.getAllFollowUps();
    }

    @GetMapping("/buscar/{id}")
    public Response<FollowUpEntity> getFollowUpById(@PathVariable Long id) {
        return followUpService.getFollowUpById(id);
    }

    @PostMapping("/agregar")
    public Response<FollowUpEntity> saveFollowUp(@RequestBody FollowUpDTO request) {
        return followUpService.saveFollowUp(request);
    }

    @PutMapping("/actualizar")
    public Response<FollowUpEntity> updateFollowUp(@RequestBody FollowUpDTO request) {
        return followUpService.updateFollowUp(request);
    }

    @PutMapping("/eliminar/{id}")
    public Response<FollowUpEntity> deleteLogicFollowUp(@PathVariable Long id) {
        return followUpService.deleteLogicFollowUp(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public Response<String> deleteFollowUp(@PathVariable Long id) {
        return followUpService.deleteFollowUp(id);
    }


}
