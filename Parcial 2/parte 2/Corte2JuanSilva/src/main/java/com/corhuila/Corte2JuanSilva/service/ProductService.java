package com.corhuila.Corte2JuanSilva.service;

import com.corhuila.Corte2JuanSilva.entity.Product;
import com.corhuila.Corte2JuanSilva.interfaz.IProductService;
import com.corhuila.Corte2JuanSilva.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        product.setState(Boolean.TRUE);
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product updateProduct = findById(product.getId());
        if (Objects.isNull(updateProduct)) {
            return null;
        }
        updateProduct.setName(Objects.nonNull(product.getName()) ? product.getName() : updateProduct.getName());
        updateProduct.setDescription(Objects.nonNull(product.getDescription()) ? product.getDescription() : updateProduct.getDescription());
        updateProduct.setUpdateAt(LocalDateTime.now());
        return productRepository.save(updateProduct);
    }

    @Override
    public Object deleteLogicById(Long id) {
        Product deletLogicalProduct = findById(id);
        if (Objects.isNull(deletLogicalProduct)) {
            return "No se encontro product por el id" + id;
        }
        deletLogicalProduct.setState(Boolean.FALSE);
        deletLogicalProduct.setDeleteAt(LocalDateTime.now());
        return productRepository.save(deletLogicalProduct);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
