package com.corhuila.Corte2JuanSilva.controller;

import com.corhuila.Corte2JuanSilva.entity.Product;
import com.corhuila.Corte2JuanSilva.interfaz.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @PutMapping(value = "/eliminadoLogico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteLogicById(@PathVariable Long id) {
        return productService.deleteLogicById(id);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
