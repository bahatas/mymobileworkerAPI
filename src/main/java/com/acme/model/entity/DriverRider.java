package com.acme.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

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


}
