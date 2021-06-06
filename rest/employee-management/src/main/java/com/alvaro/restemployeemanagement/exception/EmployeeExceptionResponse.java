package com.alvaro.restemployeemanagement.exception;

import java.util.Date;

public class EmployeeExceptionResponse {

    private String message;
    private String description;
    private Date dateTime;

    public EmployeeExceptionResponse(String message, String description, Date dateTime) {
        this.message = message;
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateTime() {
        return dateTime;
    }
}
