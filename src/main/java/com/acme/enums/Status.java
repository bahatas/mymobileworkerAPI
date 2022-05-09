package com.acme.enums;

import lombok.Getter;
import lombok.Value;

@Getter
public enum Status {

    NEW("New"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private String value;

    Status(String value){
        this.value=value;
    }
}
