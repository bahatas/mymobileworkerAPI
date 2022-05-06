package com.acme.model.entity;

import com.acme.enums.Status;
import com.acme.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="jobs")
public class Job extends BaseEntity {


    @Column(name = "job_referenceo")
    private String jobReference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "deliveryDate")
    private LocalDateTime deliveryDate;
    @Column(name = "deliveryTime")
    private LocalDateTime deliveryTime;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "driver_rider_id")
    private DriverRider driverRider;
}
