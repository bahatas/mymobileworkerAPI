package com.acme.model.dto;



import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

//    @JsonManagedReference
//    private List<JobDto> jobs;
}
