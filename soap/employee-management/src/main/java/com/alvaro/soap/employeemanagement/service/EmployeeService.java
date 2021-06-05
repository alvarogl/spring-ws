package com.alvaro.soap.employeemanagement.service;

import com.alvaro.soap.employeemanagement.service.dto.EmployeeDetails;
import java.util.List;

public interface EmployeeService {

    EmployeeDetails getEmployee(Long employeeId);

    List<EmployeeDetails> getAllEmployees();

    Boolean removeEmployee(Long employeeId);
}
