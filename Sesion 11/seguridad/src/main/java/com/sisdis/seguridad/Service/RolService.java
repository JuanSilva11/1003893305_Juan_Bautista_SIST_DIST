package com.sisdis.seguridad.Service;

import com.sisdis.seguridad.Entity.Rol;
import com.sisdis.seguridad.IRepository.IRolRepository;
import com.sisdis.seguridad.IService.IRolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RolService implements IRolService {

    private final IRolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return rol.get();
        }
        log.info("El rol con el id " + id + " no existe");
        return null;
    }

    @Override
    public Rol save(Rol rol) {
        rol.setEstado(true);
        rol.setFechaCreacion(LocalDateTime.now());
        rol.setUsuarioCreacion(1L);
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        Rol updateRol = findById(rol.getId());
        if (Objects.isNull(updateRol)) {
            log.info("El rol con el id " + rol.getId() + " no existe");
            return null;
        }
        updateRol.setCodigo(Objects.isNull(rol.getCodigo()) ? updateRol.getCodigo() : rol.getCodigo());
        updateRol.setNombre(Objects.isNull(rol.getNombre()) ? updateRol.getNombre() : rol.getNombre());
        updateRol.setDescripcion(Objects.isNull(rol.getDescripcion()) ? updateRol.getDescripcion() : rol.getDescripcion());
        updateRol.setFechaModificacion(LocalDateTime.now());
        updateRol.setUsuarioModificacion(2L);
        return rolRepository.save(updateRol);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(findById(id)))
            rolRepository.deleteById(id);
    }
}
