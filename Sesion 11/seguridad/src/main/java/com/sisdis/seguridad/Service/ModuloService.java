package com.sisdis.seguridad.Service;

import com.sisdis.seguridad.Entity.Modulo;
import com.sisdis.seguridad.Entity.Rol;
import com.sisdis.seguridad.IRepository.IModuloRepository;
import com.sisdis.seguridad.IService.IModuloService;
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
public class ModuloService implements IModuloService {

    private final IModuloRepository moduloRepository;

    @Override
    public List<Modulo> findAll() {
        return moduloRepository.findAll();
    }

    @Override
    public Modulo findById(Long id) {
        Optional<Modulo> modulo = moduloRepository.findById(id);
        if (modulo.isPresent()) {
            return modulo.get();
        }
        log.info("El modulo con el id " + id + " no existe");
        return null;
    }

    @Override
    public Modulo save(Modulo modulo) {
        modulo.setEstado(true);
        modulo.setFechaCreacion(LocalDateTime.now());
        modulo.setUsuarioCreacion(1L);
        return moduloRepository.save(modulo);
    }

    @Override
    public Modulo update(Modulo modulo) {
        Modulo updateModulo = findById(modulo.getId());
        if (Objects.isNull(updateModulo)){
            log.info("El modulo con el id " + modulo.getId() + " no existe");
            return null;
        }
        updateModulo.setCodigo(Objects.isNull(modulo.getCodigo()) ? updateModulo.getCodigo() : modulo.getCodigo());
        updateModulo.setNombre(Objects.isNull(modulo.getNombre()) ? updateModulo.getNombre() : modulo.getNombre());
        updateModulo.setDescripcion(Objects.isNull(modulo.getDescripcion()) ? updateModulo.getDescripcion() : modulo.getDescripcion());
        updateModulo.setFechaModificacion(LocalDateTime.now());
        updateModulo.setUsuarioModificacion(2L);
        return moduloRepository.save(updateModulo);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(findById(id)))
            moduloRepository.deleteById(id);
    }
}
