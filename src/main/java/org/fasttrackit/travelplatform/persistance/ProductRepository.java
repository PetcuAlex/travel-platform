package org.fasttrackit.travelplatform.persistance;

import org.fasttrackit.travelplatform.persistence.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
