package com.corhuila.Corte2JuanSilva.service;

import com.corhuila.Corte2JuanSilva.entity.Customer;
import com.corhuila.Corte2JuanSilva.interfaz.ICustomerService;
import com.corhuila.Corte2JuanSilva.repository.ICustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        customer.setState(Boolean.TRUE);
        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Customer updateCustomer = findById(customer.getId());
        if (Objects.isNull(updateCustomer)) {
            return null;
        }
        updateCustomer.setName(Objects.nonNull(customer.getName()) ? customer.getName() : updateCustomer.getName());
        updateCustomer.setEmail(Objects.nonNull(customer.getEmail()) ? customer.getEmail() : updateCustomer.getEmail());
        updateCustomer.setPhone(Objects.nonNull(customer.getPhone()) ? customer.getPhone() : updateCustomer.getPhone());
        updateCustomer.setAddress(Objects.nonNull(customer.getAddress()) ? customer.getAddress() : updateCustomer.getAddress());
        updateCustomer.setUpdateAt(LocalDateTime.now());
        return customerRepository.save(updateCustomer);
    }

    @Override
    public Object deleteLogicById(Long id) {
        Customer deleteLogicalCustomer = findById(id);
        if (Objects.isNull(deleteLogicalCustomer)) {
            return "No se encontro customer por el id" + id;
        }
        deleteLogicalCustomer.setState(Boolean.FALSE);
        deleteLogicalCustomer.setDeleteAt(LocalDateTime.now());
        return customerRepository.save(deleteLogicalCustomer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
