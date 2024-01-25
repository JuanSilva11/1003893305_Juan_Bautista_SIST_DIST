package com.sisdis.seguridad.IService;

import com.sisdis.seguridad.Entity.Modulo;

import java.util.List;

public interface IModuloService {

    List<Modulo> findAll();

    Modulo findById(Long id);

    Modulo save(Modulo modulo);

    Modulo update(Modulo modulo);

    void delete(Long id);

}
