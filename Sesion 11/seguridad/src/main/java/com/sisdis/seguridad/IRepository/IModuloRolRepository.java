package com.sisdis.seguridad.IRepository;

import com.sisdis.seguridad.Entity.ModuloRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuloRolRepository extends JpaRepository<ModuloRol, Long> {
}
