package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.UserDTO;
import com.corhuila.proyecto.entity.UserEntity;

import java.util.List;

public interface UserServcie {

    Response<List<UserEntity>> getAllUsers();

    Response<UserEntity> getUserById(Long id);

    Response<UserEntity> saveUser(UserDTO request);

    Response<UserEntity> updateUser(UserDTO request);

    Response<UserEntity> deleteLogicUser(Long id);

    Response<String> deleteUser(Long id);

}
