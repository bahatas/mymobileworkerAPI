package com.acme.enums;

public enum Status {

    NEW("New"),
    DONE("Done"),
    CANCELED("Canceled");

    private String value;

    Status(String value){
        this.value=value;
    }
}
