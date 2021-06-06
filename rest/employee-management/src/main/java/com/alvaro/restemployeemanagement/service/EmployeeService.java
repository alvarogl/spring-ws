package com.alvaro.restemployeemanagement.service;

import com.alvaro.restemployeemanagement.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    Boolean deleteEmployee(Long employeeId);
}
