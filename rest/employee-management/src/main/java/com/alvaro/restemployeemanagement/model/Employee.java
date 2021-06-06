package com.alvaro.restemployeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "EMPLOYEE")
@Entity
public class Employee {

    private Long employeeId;
    @NotBlank
    @Size(min = 2, message = "Wrong length for firstName")
    private String firstName;
    @NotBlank
    @Size(min = 2, message = "Wrong length for lastName")
    private String lastName;
    private String location;
    @Digits(integer = 5, fraction = 0)
    private Integer zipCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}