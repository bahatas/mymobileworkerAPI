package com.acme.model.dto;

import com.acme.enums.Status;
import com.acme.model.entity.JobItem;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
@ToString
public class JobDto {


    @JsonProperty(required = true)
    private Long id;

    private String jobReference;

    @JsonProperty(value = "client_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ClientDto client;

    private String location;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deliveryDate;

    @JsonFormat(pattern="HH:mm:ss",shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime deliveryTime;

    private Status status;

    @JsonProperty(value = "driverRider_id")
    @JsonIdentityReference(alwaysAsId = true)
    private DriverRiderDto driverRider;

    @JsonProperty(value = "jobItemList_id")
    private List<JobItem> jobItems;



}
