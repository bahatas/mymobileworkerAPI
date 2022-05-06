package com.acme.model;

import com.acme.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class JobDto {

    private Long id;
    private String jobReference;
    private ClientDto client;
    private String location;
    private String description;
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private Status status;



}
