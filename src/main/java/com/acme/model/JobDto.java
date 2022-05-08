package com.acme.model;

import com.acme.enums.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("client")
public class JobDto {


    @JsonProperty(required = true)
    private Long id;
    private String jobReference;
    @JsonProperty(value = "client_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference
    private ClientDto clientId;
    private String location;
    private String description;
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private Status status;

    @JsonProperty(value = "driverRider_id")
    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference
    private DriverRiderDto driverRider;



}
