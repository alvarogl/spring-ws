package com.alvaro.restemployeemanagement.repo;

import com.alvaro.restemployeemanagement.model.Employee;
import com.alvaro.restemployeemanagement.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PreloadData implements ApplicationRunner {

    private final EmployeeRepository employeeRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public PreloadData(EmployeeRepository employeeRepository, UserDetailsRepository userDetailsRepository) {
        this.employeeRepository = employeeRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Employee e1 = new Employee();
        e1.setEmployeeId(1L);
        e1.setFirstName("Luke");
        e1.setLastName("Skywalker");
        e1.setLocation("Tatooine");
        e1.setZipCode(12345);
        employeeRepository.save(e1);

        Employee e2 = new Employee();
        e2.setEmployeeId(2L);
        e2.setFirstName("Darth");
        e2.setLastName("Vader");
        e2.setLocation("Death Star");
        employeeRepository.save(e2);

        UserDetails ud1 = new UserDetails();
        ud1.setUserName("lukeSkywalker");
        ud1.setPanNumber("AB9911Z");
        userDetailsRepository.save(ud1);

        UserDetails ud2 = new UserDetails();
        ud2.setUserName("darth_vader");
        ud2.setPanNumber("ZZ112233F");
        userDetailsRepository.save(ud1);
    }
}
