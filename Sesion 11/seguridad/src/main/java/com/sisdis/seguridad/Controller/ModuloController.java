package com.sisdis.seguridad.Controller;

import com.sisdis.seguridad.Entity.Modulo;
import com.sisdis.seguridad.IService.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/Modulo")
public class ModuloController {

    @Autowired
    private IModuloService moduloService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modulo> findAll() {
        return moduloService.findAll();
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Modulo findById(@PathVariable Long id) {
        return moduloService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Modulo save(@RequestBody Modulo modulo) {
        return moduloService.save(modulo);
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Modulo update(@RequestBody Modulo modulo) {
        return moduloService.update(modulo);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        moduloService.delete(id);
    }

}
