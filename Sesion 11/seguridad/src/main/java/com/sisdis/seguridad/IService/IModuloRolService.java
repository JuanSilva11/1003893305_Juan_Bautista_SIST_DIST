package com.sisdis.seguridad.IService;

import com.sisdis.seguridad.Entity.ModuloRol;

import java.util.List;

public interface IModuloRolService {

    List<ModuloRol> findAll();

    ModuloRol findById(Long id);

    ModuloRol save(ModuloRol moduloRol);

    ModuloRol update(ModuloRol moduloRol);

    void delete(Long id);

}
