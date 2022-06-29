package io.company.securityDemo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Long> {
	Optional<Customer> findByUsername(String username);
}
