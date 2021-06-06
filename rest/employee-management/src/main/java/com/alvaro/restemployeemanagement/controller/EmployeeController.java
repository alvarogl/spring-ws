package com.alvaro.restemployeemanagement.controller;

import com.alvaro.restemployeemanagement.exception.EmployeeNotFoundException;
import com.alvaro.restemployeemanagement.model.Employee;
import com.alvaro.restemployeemanagement.service.EmployeeService;
import java.net.URI;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        EntityModel<Employee> entityModel = EntityModel.of(employee);
        Link link = WebMvcLinkBuilder
            .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEmployees())
            .withRel("all-employees");

        entityModel.add(link);

        return entityModel;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeId}")
            .buildAndExpand(newEmployee.getEmployeeId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
}
