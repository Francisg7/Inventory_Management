package com.eurekadevops.sabre.web.errors;

public class OrderErrorResponse extends ErrorResponse {

    public OrderErrorResponse() {
    }

    public OrderErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
