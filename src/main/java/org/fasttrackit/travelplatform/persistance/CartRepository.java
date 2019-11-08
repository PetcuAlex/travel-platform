package org.fasttrackit.travelplatform.persistance;

import org.fasttrackit.travelplatform.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
