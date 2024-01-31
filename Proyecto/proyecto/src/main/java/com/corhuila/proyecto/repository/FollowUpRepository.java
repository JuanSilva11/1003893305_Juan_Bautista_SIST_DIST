package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.entity.FollowUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUpEntity, Long> {
}
