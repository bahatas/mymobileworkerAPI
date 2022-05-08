package com.acme.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRiderDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
//    @JsonManagedReference
    private List<JobDto> jobs;
}
