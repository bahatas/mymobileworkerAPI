package com.acme.model.entity;

import com.acme.enums.Status;
import com.acme.model.BaseEntity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "deliveryDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime deliveryDate;

    @Column(name = "deliveryTime")
    @JsonFormat(pattern="HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime deliveryTime;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_rider_id")
    private DriverRider driverRider;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "job")
    private List<JobItem> jobItems;
}
