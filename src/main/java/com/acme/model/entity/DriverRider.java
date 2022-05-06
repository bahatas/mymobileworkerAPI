package com.acme.model.entity;

import com.acme.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="drivers")
public class DriverRider extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToOne
    private Job job;
}
