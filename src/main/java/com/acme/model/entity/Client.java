package com.acme.model.entity;

import com.acme.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Job> job;

}
