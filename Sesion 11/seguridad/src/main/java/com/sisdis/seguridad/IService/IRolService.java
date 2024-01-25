package com.sisdis.seguridad.IService;

import com.sisdis.seguridad.Entity.Rol;

import java.util.List;

public interface IRolService {

    List<Rol> findAll();

    Rol findById(Long id);

    Rol save(Rol rol);

    Rol update(Rol rol);

    void delete(Long id);

}
