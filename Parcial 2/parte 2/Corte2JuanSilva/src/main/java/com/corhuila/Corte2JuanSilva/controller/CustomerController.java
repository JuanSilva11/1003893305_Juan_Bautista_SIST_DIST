package com.corhuila.Corte2JuanSilva.controller;

import com.corhuila.Corte2JuanSilva.entity.Customer;
import com.corhuila.Corte2JuanSilva.interfaz.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @PutMapping(value = "/eliminadoLogico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteLogicById(@PathVariable Long id) {
        return customerService.deleteLogicById(id);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

}
