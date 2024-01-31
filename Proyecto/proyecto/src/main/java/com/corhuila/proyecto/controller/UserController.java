package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.UserDTO;
import com.corhuila.proyecto.entity.UserEntity;
import com.corhuila.proyecto.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/usuarios")
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @GetMapping("/listar")
    public Response<List<UserEntity>> getAllUsers() {
        return userServcie.getAllUsers();
    }

    @GetMapping("/buscar/{id}")
    public Response<UserEntity> getUserById(@PathVariable Long id) {
        return userServcie.getUserById(id);
    }

    @PostMapping("/agregar")
    public Response<UserEntity> saveUser(@RequestBody UserDTO request) {
        return userServcie.saveUser(request);
    }

    @PutMapping("/actualizar")
    public Response<UserEntity> updateUser(@RequestBody UserDTO request) {
        return userServcie.updateUser(request);
    }

    @PutMapping("/eliminar/{id}")
    public Response<UserEntity> deleteLogicUser(@PathVariable Long id) {
        return userServcie.deleteLogicUser(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public Response<String> deleteUser(@PathVariable Long id) {
        return userServcie.deleteUser(id);
    }

}