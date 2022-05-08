package com.acme.model.entity;

import com.acme.enums.Status;
import com.acme.model.BaseEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="jobs")
@Where(clause = "is_deleted=false")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","client"},ignoreUnknown = true)
public class Job extends BaseEntity {



    @Column(name = "job_referenceo")
    private String jobReference;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonBackReference
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

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "driver_rider_id")
    @JsonBackReference
    private DriverRider driverRider;
}