package com.alvaro.soap.employeemanagement.service;

import com.alvaro.soap.employeemanagement.repo.EmployeeRepository;
import com.alvaro.soap.employeemanagement.service.dto.EmployeeDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeDetails getEmployee(Long employeeId) {
        return repository
            .findById(employeeId).map(emp -> MAPPER.convertValue(emp, EmployeeDetails.class))
            .orElse(new EmployeeDetails());

    }

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        return repository.findAll().stream()
            .map(emp -> MAPPER.convertValue(emp, EmployeeDetails.class)).collect(
                Collectors.toList());
    }

    @Override
    public Boolean removeEmployee(Long employeeId) {
        return repository.findById(employeeId).map(emp -> {
            repository.delete(emp);
            return true;
        }).orElse(false);
    }
}
