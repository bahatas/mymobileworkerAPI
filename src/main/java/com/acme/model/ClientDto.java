package com.acme.model;



import lombok.Data;



import java.util.List;


@Data
public class ClientDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<JobDto> job;
}
