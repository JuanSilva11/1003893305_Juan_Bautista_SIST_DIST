package com.corhuila.Corte2JuanSilva.interfaz;

import com.corhuila.Corte2JuanSilva.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    Object deleteLogicById(Long id);

    void deleteById(Long id);

}
