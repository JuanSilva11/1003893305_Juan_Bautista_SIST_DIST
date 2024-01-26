package com.corhuila.Corte2JuanSilva.repository;

import com.corhuila.Corte2JuanSilva.entity.CustomerProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerProductRepository extends JpaRepository<CustomerProduct, Long> {
}
