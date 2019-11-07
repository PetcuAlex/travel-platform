package org.fasttrackit.travelplatform.persistance;

import org.fasttrackit.travelplatform.persistence.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(String partialName, Pageable pageable);

    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(String partialName, int minimumQuantity, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE name LIKE '%?1%'",nativeQuery = true)
    List<Product> findByPartialName(String partialName);
}
