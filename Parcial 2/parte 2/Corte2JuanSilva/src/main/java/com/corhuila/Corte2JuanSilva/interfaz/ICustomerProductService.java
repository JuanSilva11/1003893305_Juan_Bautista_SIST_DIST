package com.corhuila.Corte2JuanSilva.interfaz;

import com.corhuila.Corte2JuanSilva.entity.CustomerProduct;

import java.util.List;

public interface ICustomerProductService {

    List<CustomerProduct> findAll();

    CustomerProduct findById(Long id);

    CustomerProduct save(CustomerProduct customerProduct);

    CustomerProduct update(CustomerProduct customerProduct);

    Object deleteLogicById(Long id);

    void deleteById(Long id);

}
