package com.corhuila.Corte2JuanSilva.controller;

import com.corhuila.Corte2JuanSilva.entity.CustomerProduct;
import com.corhuila.Corte2JuanSilva.interfaz.ICustomerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer-product")
public class CustomerProductController {

    @Autowired
    private ICustomerProductService customerProductService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerProduct> findAll() {
        return customerProductService.findAll();
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerProduct findById(@PathVariable Long id) {
        return customerProductService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerProduct save(@RequestBody CustomerProduct  customerProduct) {
        return customerProductService.save(customerProduct);
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerProduct update(@RequestBody CustomerProduct customerProduct) {
        return customerProductService.update(customerProduct);
    }

    @PutMapping(value = "/eliminadoLogico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteLogicById(@PathVariable Long id) {
        return customerProductService.deleteLogicById(id);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        customerProductService.deleteById(id);
    }

}
