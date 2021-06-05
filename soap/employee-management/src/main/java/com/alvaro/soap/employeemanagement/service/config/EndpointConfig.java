package com.alvaro.soap.employeemanagement.service.config;

import com.alvaro.soap.employeemanagement.service.EmployeeService;
import com.alvaro.soap.employeemanagement.service.dto.DeleteEmployeeRequest;
import com.alvaro.soap.employeemanagement.service.dto.DeleteEmployeeResponse;
import com.alvaro.soap.employeemanagement.service.dto.EmployeeDetails;
import com.alvaro.soap.employeemanagement.service.dto.GetAllEmployeesRequest;
import com.alvaro.soap.employeemanagement.service.dto.GetAllEmployeesResponse;
import com.alvaro.soap.employeemanagement.service.dto.GetEmployeeRequest;
import com.alvaro.soap.employeemanagement.service.dto.GetEmployeeResponse;
import com.alvaro.soap.employeemanagement.service.dto.ObjectFactory;
import javax.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EndpointConfig {

    @Autowired
    private EmployeeService service;

    @PayloadRoot(namespace = "http://localhost/hrms", localPart = "GetEmployeeRequest")
    @ResponsePayload
    public JAXBElement<GetEmployeeResponse> getEmployee(
        @RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();

        EmployeeDetails details = service.getEmployee(request.getEmployeeId());
        response.setEmployeeDetails(details);

        return new ObjectFactory().createGetEmployeeResponse(response);
    }

    @PayloadRoot(namespace = "http://localhost/hrms", localPart = "GetAllEmployeesRequest")
    @ResponsePayload
    public JAXBElement<GetAllEmployeesResponse> getAllEmployees(
        @RequestPayload GetAllEmployeesRequest request) {
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();

        response.getEmployeeDetails().addAll(service.getAllEmployees());

        return new ObjectFactory().createGetAllEmployeesResponse(response);
    }

    @PayloadRoot(namespace = "http://localhost/hrms", localPart = "DeleteEmployeeRequest")
    @ResponsePayload
    public JAXBElement<DeleteEmployeeResponse> deleteEmployee(
        @RequestPayload DeleteEmployeeRequest request) {
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();

        response.setStatus(service.removeEmployee(request.getEmployeeId()));

        return new ObjectFactory().createDeleteEmployeeResponse(response);
    }
}
