package com.acme.model.entity;

import com.acme.model.BaseEntity;
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
@Table(name = "clients")
@Where(clause = "is_deleted=false")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class Client extends BaseEntity {


    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

//    @OneToMany(mappedBy = "client",
//            cascade = {CascadeType.ALL},
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//
//    private List<Job> jobs;

}
