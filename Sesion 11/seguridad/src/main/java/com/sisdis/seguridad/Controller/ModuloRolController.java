package com.sisdis.seguridad.Controller;

import com.sisdis.seguridad.Entity.Modulo;
import com.sisdis.seguridad.Entity.ModuloRol;
import com.sisdis.seguridad.IService.IModuloRolService;
import com.sisdis.seguridad.IService.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/ModuloRol")
public class ModuloRolController {

    @Autowired
    private IModuloRolService moduloRolService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModuloRol> findAll() {
        return moduloRolService.findAll();
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModuloRol findById(@PathVariable Long id) {
        return moduloRolService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModuloRol save(@RequestBody ModuloRol moduloRol) {
        return moduloRolService.save(moduloRol);
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModuloRol update(@RequestBody ModuloRol moduloRol) {
        return moduloRolService.update(moduloRol);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        moduloRolService.delete(id);
    }

}
