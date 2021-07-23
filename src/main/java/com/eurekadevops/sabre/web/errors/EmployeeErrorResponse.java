package com.eurekadevops.sabre.web.errors;

public class EmployeeErrorResponse extends ErrorResponse {

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
