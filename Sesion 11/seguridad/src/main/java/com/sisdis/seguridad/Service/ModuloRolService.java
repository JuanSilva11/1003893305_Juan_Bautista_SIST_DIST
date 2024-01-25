package com.sisdis.seguridad.Service;

import com.sisdis.seguridad.Entity.Modulo;
import com.sisdis.seguridad.Entity.ModuloRol;
import com.sisdis.seguridad.Entity.Rol;
import com.sisdis.seguridad.IRepository.IModuloRolRepository;
import com.sisdis.seguridad.IService.IModuloRolService;
import com.sisdis.seguridad.IService.IModuloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModuloRolService implements IModuloRolService {

    private final IModuloRolRepository moduloRolRepository;

    private final IModuloService moduloService;

    private final RolService rolService;

    @Override
    public List<ModuloRol> findAll() {
        return moduloRolRepository.findAll();
    }

    @Override
    public ModuloRol findById(Long id) {
        Optional<ModuloRol> moduloRol = moduloRolRepository.findById(id);
        if (moduloRol.isPresent()) {
            return moduloRol.get();
        }
        log.info("El moduloRol con el id " + id + " no existe");
        return null;
    }

    @Override
    public ModuloRol save(ModuloRol moduloRol) {
        Modulo modulo = moduloService.findById(moduloRol.getModuloId().getId());
        if (Objects.nonNull(modulo)) {
            moduloRol.setModuloId(modulo);
        }
        Rol rol = rolService.findById(moduloRol.getRolId().getId());
        if (Objects.nonNull(rol)) {
            moduloRol.setRolId(rol);
        }
        return moduloRolRepository.save(moduloRol);
    }

    @Override
    public ModuloRol update(ModuloRol moduloRol) {
        ModuloRol updateModuloRol = findById(moduloRol.getId());
        if (Objects.isNull(updateModuloRol)) {
            log.info("El moduloRol con el id " + moduloRol.getId() + " no existe");
            return null;
        }
        Modulo modulo = moduloService.findById(moduloRol.getModuloId().getId());
        if (Objects.nonNull(modulo)) {
            updateModuloRol.setModuloId(modulo);
        }
        Rol rol = rolService.findById(moduloRol.getRolId().getId());
        if (Objects.nonNull(rol)) {
            updateModuloRol.setRolId(rol);
        }
        return moduloRolRepository.save(updateModuloRol);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(findById(id)))
            moduloRolRepository.deleteById(id);
    }
}
