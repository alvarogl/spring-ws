package com.alvaro.soap.employeemanagement.repo;

import com.alvaro.soap.employeemanagement.model.Employee;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    Set<Employee> findAll();
}
