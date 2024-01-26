package com.corhuila.Corte2JuanSilva.repository;

import com.corhuila.Corte2JuanSilva.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
