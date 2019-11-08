package org.fasttrackit.travelplatform.persistance;

import org.fasttrackit.travelplatform.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
