package com.corhuila.Corte2JuanSilva.service;

import com.corhuila.Corte2JuanSilva.entity.Customer;
import com.corhuila.Corte2JuanSilva.entity.CustomerProduct;
import com.corhuila.Corte2JuanSilva.entity.Product;
import com.corhuila.Corte2JuanSilva.interfaz.ICustomerProductService;
import com.corhuila.Corte2JuanSilva.interfaz.ICustomerService;
import com.corhuila.Corte2JuanSilva.interfaz.IProductService;
import com.corhuila.Corte2JuanSilva.repository.ICustomerProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CustomerProductService implements ICustomerProductService {

    @Autowired
    private ICustomerProductRepository customerProductRepository;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;

    @Override
    public List<CustomerProduct> findAll() {
        return customerProductRepository.findAll();
    }

    @Override
    public CustomerProduct findById(Long id) {
        return customerProductRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerProduct save(CustomerProduct customerProduct) {
        Customer customer = customerService.findById(customerProduct.getCustomer().getId());
        Product product = productService.findById(customerProduct.getProduct().getId());
        if (Objects.isNull(customer) || Objects.isNull(product)) {
            log.info("El customer y/o producto a asociar no existe");
            return null;
        }
        customerProduct.setCustomer(customer);
        customerProduct.setProduct(product);
        customer.setState(Boolean.TRUE);
        customer.setCreatedAt(LocalDateTime.now());
        return customerProductRepository.save(customerProduct);
    }

    @Override
    public CustomerProduct update(CustomerProduct customerProduct) {
        CustomerProduct updateCustomerProduct = findById(customerProduct.getId());
        if (Objects.isNull(updateCustomerProduct)){
            log.info("No se encontro el customer-product a actualizar");
            return null;
        }
        Customer customer = customerService.findById(customerProduct.getCustomer().getId());
        Product product = productService.findById(customerProduct.getProduct().getId());
        if (Objects.isNull(customer) || Objects.isNull(product)) {
            log.info("El customer y/o producto a asociar no existe");
            return null;
        }
        updateCustomerProduct.setCustomer(customer);
        updateCustomerProduct.setProduct(product);
        updateCustomerProduct.setUpdateAt(LocalDateTime.now());
        return customerProductRepository.save(updateCustomerProduct);
    }

    @Override
    public Object deleteLogicById(Long id) {
        CustomerProduct customerProduct = findById(id);
        if (Objects.isNull(customerProduct)){
            return "No se encontro el customer-product a eliminar";
        }
        customerProduct.setState(Boolean.FALSE);
        customerProduct.setDeleteAt(LocalDateTime.now());
        return customerProductRepository.save(customerProduct);
    }

    @Override
    public void deleteById(Long id) {
        customerProductRepository.deleteById(id);
    }
}
