package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findAllByPriceLessThanEqual(Long price);
}

