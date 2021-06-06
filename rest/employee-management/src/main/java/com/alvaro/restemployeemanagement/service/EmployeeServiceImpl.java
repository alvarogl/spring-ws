package com.alvaro.restemployeemanagement.service;

import com.alvaro.restemployeemanagement.exception.EmployeeNotFoundException;
import com.alvaro.restemployeemanagement.model.Employee;
import com.alvaro.restemployeemanagement.repo.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return repository.findById(employeeId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Boolean deleteEmployee(Long employeeId) {
        return repository.findById(employeeId).map(emp -> {
            repository.delete(emp);
            return true;
        }).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }
}
