package com.sisdis.seguridad.Controller;

import com.sisdis.seguridad.Entity.Rol;
import com.sisdis.seguridad.IService.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/Rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rol> findAll() {
        return rolService.findAll();
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rol findById(@PathVariable Long id) {
        return rolService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rol save(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rol update(@RequestBody Rol rol) {
        return rolService.update(rol);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        rolService.delete(id);
    }

}
