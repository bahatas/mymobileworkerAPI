package com.acme.model.entity;

import com.acme.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="drivers_riders")
@Where(clause = "is_deleted=false")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","jobs"},ignoreUnknown = true)
public class DriverRider extends BaseEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

//    @OneToMany(mappedBy = "driverRider",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//
//    private List<Job> jobs;
}
