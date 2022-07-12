package io.company.library;

import java.util.Optional;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	Optional<Employee> findById(String id);

	Iterable<Employee> findItemByName(String name);

}
