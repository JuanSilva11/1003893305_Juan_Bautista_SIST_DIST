package com.corhuila.Corte2JuanSilva.interfaz;

import com.corhuila.Corte2JuanSilva.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    Product update(Product product);

    Object deleteLogicById(Long id);

    void deleteById(Long id);

}
