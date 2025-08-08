package org.example.arquitecturaMonolitica.repository;

import org.example.arquitecturaMonolitica.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
