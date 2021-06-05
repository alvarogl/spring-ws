package com.alvaro.soap.employeemanagement.repo;


import com.alvaro.soap.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PreloadData implements ApplicationRunner {

    private EmployeeRepository repository;

    @Autowired
    public PreloadData(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Employee e1 = new Employee();
        e1.setEmployeeId(1L);
        e1.setFirstName("Luke");
        e1.setLastName("Skywalker");
        e1.setLocation("Tatooine");
        e1.setZipCode(12345);
        repository.save(e1);

        Employee e2 = new Employee();
        e2.setEmployeeId(2L);
        e2.setFirstName("Darth");
        e2.setLastName("Vader");
        e2.setLocation("Death Star");
        repository.save(e2);
    }
}
