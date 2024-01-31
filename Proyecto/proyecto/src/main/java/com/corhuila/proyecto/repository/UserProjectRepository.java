package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.entity.UserProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProjectEntity, Long> {

    List<UserProjectEntity> findByProjectId(Long idProject);

    List<UserProjectEntity> findByUserId(Long idUser);

}
