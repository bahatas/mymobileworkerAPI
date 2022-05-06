package com.acme.model;

import com.acme.enums.Status;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class Job {

    private Long id;
    private String jobReference;
    private Client client;
    private String location;
    private String description;
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private Status status;



}
