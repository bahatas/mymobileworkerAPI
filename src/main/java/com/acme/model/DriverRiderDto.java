package com.acme.model;


import lombok.Data;

@Data
public class DriverRiderDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private JobDto job;
}
