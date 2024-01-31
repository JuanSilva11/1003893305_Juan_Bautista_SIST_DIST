package com.corhuila.proyecto.implement;

import com.corhuila.proyecto.dto.FollowUpDTO;
import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.FollowUpEntity;
import com.corhuila.proyecto.repository.FollowUpRepository;
import com.corhuila.proyecto.service.FollowUpService;
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
public class FollowUpServiceImpl implements FollowUpService {

    private final FollowUpRepository followUpRepository;

    @Override
    public Response<List<FollowUpEntity>> getAllFollowUps() {
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), followUpRepository.findAll());
    }

    @Override
    public Response<FollowUpEntity> getFollowUpById(Long id) {
        Optional<FollowUpEntity> followUp = followUpRepository.findById(id);
        if (followUp.isEmpty()) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_02.getCode(), Constants.RESPONSE_CODE_02.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), followUp.get());
    }

    @Override
    public Response<FollowUpEntity> saveFollowUp(FollowUpDTO request) {
        FollowUpEntity followUp = FollowUpEntity.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .observations(request.getObservations())
                .taskId(request.getTaskId())
                .build();
        followUp.setState(true);
        followUp.setCreatedAt(LocalDateTime.now());
        try {
            followUpRepository.save(followUp);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al guardar el seguimiento: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }

        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), followUpRepository.findById(followUp.getId()).get());
    }

    @Override
    public Response<FollowUpEntity> updateFollowUp(FollowUpDTO request) {
        Response<FollowUpEntity> updateFollowUp = getFollowUpById(request.getId());
        if (!Objects.equals(updateFollowUp.getResponseCode(), 1) && Objects.isNull(updateFollowUp.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_04.getCode(), Constants.RESPONSE_CODE_04.getMessage(), null);
        }
        FollowUpEntity followUp = updateFollowUp.getData();
        followUp.setStartDate(request.getStartDate());
        followUp.setEndDate(request.getEndDate());
        followUp.setObservations(request.getObservations());
        followUp.setTaskId(request.getTaskId());
        followUp.setUpdatedAt(LocalDateTime.now());
        try {
            followUpRepository.save(followUp);
        } catch (DataIntegrityViolationException e) {
            log.error("Ha ocurrido un error al actualizar el seguimiento: {}", e.getMessage());
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_03.getCode(), Constants.RESPONSE_CODE_03.getMessage(), null);
        }
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), followUp);
    }

    @Override
    public Response<FollowUpEntity> deleteLogicFollowUp(Long id) {
        Response<FollowUpEntity> updateFollowUp = getFollowUpById(id);
        if (!Objects.equals(updateFollowUp.getResponseCode(), 1) && Objects.isNull(updateFollowUp.getData())) {
            return GenericServices.buildResponse(updateFollowUp.getResponseCode(), updateFollowUp.getResponseMessage(), null);
        }
        FollowUpEntity followUp = updateFollowUp.getData();
        followUp.setState(false);
        followUp.setDeletedAt(LocalDateTime.now());
        followUpRepository.save(followUp);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), followUp);
    }

    @Override
    public Response<String> deleteFollowUp(Long id) {
        Response<FollowUpEntity> followUp = getFollowUpById(id);
        if (!Objects.equals(followUp.getResponseCode(), 1) && Objects.isNull(followUp.getData())) {
            return GenericServices.buildResponse(Constants.RESPONSE_CODE_05.getCode(), Constants.RESPONSE_CODE_05.getMessage(), null);
        }
        followUpRepository.deleteById(id);
        return GenericServices.buildResponse(Constants.RESPONSE_CODE_01.getCode(), Constants.RESPONSE_CODE_01.getMessage(), "Seguimiento eliminado correctamente");
    }
}
