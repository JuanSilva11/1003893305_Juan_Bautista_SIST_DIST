package com.corhuila.proyecto.implement;

import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.dto.UserDTO;
import com.corhuila.proyecto.entity.UserEntity;
import com.corhuila.proyecto.repository.UserRepository;
import com.corhuila.proyecto.service.UserServcie;
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
public class UserServiceImpl implements UserServcie {

    private final UserRepository userRepository;

    @Override
    public Response<List<UserEntity>> getAllUsers() {
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), userRepository.findAll());
    }

    @Override
    public Response<UserEntity> getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_02.getCode(), Constants.RESPONSE_CODE_02.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), user.get());
    }

    @Override
    public Response<UserEntity> saveUser(UserDTO request) {
        UserEntity user = UserEntity.builder()
                .documentType(request.getDocumentType())
                .documentNumber(request.getDocumentNumber())
                .names(request.getNames())
                .surnames(request.getSurnames())
                .build();
        user.setState(true);
        user.setCreatedAt(LocalDateTime.now());
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al guardar el usuario: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), user);
    }

    @Override
    public Response<UserEntity> updateUser(UserDTO request) {
        Response<UserEntity> updateUser = getUserById(request.getId());
        if (!Objects.equals(updateUser.getResponseCode(), 1) && Objects.isNull(updateUser.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_04.getCode(), Constants.RESPONSE_CODE_04.getMessage(), null);
        }
        UserEntity user = updateUser.getData();
        user.setDocumentType(request.getDocumentType());
        user.setDocumentNumber(request.getDocumentNumber());
        user.setNames(request.getNames());
        user.setSurnames(request.getSurnames());
        user.setUpdatedAt(LocalDateTime.now());
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al actualizar el usuario: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), user);
    }

    @Override
    public Response<UserEntity> deleteLogicUser(Long id) {
        Response<UserEntity> updateUser = getUserById(id);
        if (!Objects.equals(updateUser.getResponseCode(), 1) && Objects.isNull(updateUser.getData())) {
            return GenericServices.buildResponse(updateUser.getResponseCode(), updateUser.getResponseMessage(), null);
        }
        UserEntity user = updateUser.getData();
        user.setState(false);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), user);
    }

    @Override
    public Response<String> deleteUser(Long id) {
        Response<UserEntity> updateUser = getUserById(id);
        if (!Objects.equals(updateUser.getResponseCode(), 1) && Objects.isNull(updateUser.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_05.getCode(), Constants.RESPONSE_CODE_05.getMessage(), null);
        }
        userRepository.deleteById(id);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), "Usuario eliminado correctamente");
    }

}
