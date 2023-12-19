package com.webservice.restful.model;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = "Hello " + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
