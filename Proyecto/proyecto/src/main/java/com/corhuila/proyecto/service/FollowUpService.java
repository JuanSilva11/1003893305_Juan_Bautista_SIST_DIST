package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.FollowUpDTO;
import com.corhuila.proyecto.dto.Response;
import com.corhuila.proyecto.entity.FollowUpEntity;

import java.util.List;

public interface FollowUpService {

    Response<List<FollowUpEntity>> getAllFollowUps();

    Response<FollowUpEntity> getFollowUpById(Long id);

    Response<FollowUpEntity> saveFollowUp(FollowUpDTO request);

    Response<FollowUpEntity> updateFollowUp(FollowUpDTO request);

    Response<FollowUpEntity> deleteLogicFollowUp(Long id);

    Response<String> deleteFollowUp(Long id);

}
