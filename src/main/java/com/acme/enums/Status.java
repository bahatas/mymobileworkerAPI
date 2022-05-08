package com.acme.enums;

import lombok.Getter;
import lombok.Value;

@Getter
public enum Status {

    NEW("New"),
    DONE("Done"),
    CANCELED("Canceled");

    private String value;

    Status(String value){
        this.value=value;
    }
}
