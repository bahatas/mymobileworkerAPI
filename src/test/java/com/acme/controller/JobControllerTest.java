package com.acme.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.acme.enums.Status;
import com.acme.exception.AcmeException;
import com.acme.model.ResultEnvelope;
import com.acme.model.dto.ClientDto;
import com.acme.model.dto.DriverRiderDto;
import com.acme.model.dto.JobDto;
import com.acme.model.entity.Client;
import com.acme.model.entity.DriverRider;
import com.acme.model.entity.Job;
import com.acme.model.entity.JobItem;
import com.acme.repository.ClientRepository;
import com.acme.repository.DriverRiderRepository;
import com.acme.repository.JobRepository;
import com.acme.service.JobService;
import com.acme.service.JobServiceImpl;
import com.acme.util.MapperUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class JobControllerTest {
    @Test
    void testCerateJob() throws AcmeException {
        JobService jobService = mock(JobService.class);
        when(jobService.save((JobDto) any())).thenReturn(new JobDto());
        JobController jobController = new JobController(jobService);
        JobDto jobDto = new JobDto();
        ResultEnvelope<JobDto> actualCerateJobResult = jobController.cerateJob(jobDto);
        assertEquals(200, actualCerateJobResult.getCode().intValue());
        assertTrue(actualCerateJobResult.isSuccess());
        assertNull(actualCerateJobResult.getMetadata());
        assertNull(actualCerateJobResult.getErrors());
        assertEquals(jobDto, actualCerateJobResult.getData());
        verify(jobService).save((JobDto) any());
    }

    @Test
    void testGetJobsList() {
        JobRepository jobRepository = mock(JobRepository.class);
        ArrayList<Job> jobList = new ArrayList<>();
        when(jobRepository.findAll()).thenReturn(jobList);
        ClientRepository clientRepository = mock(ClientRepository.class);
        DriverRiderRepository driverRiderRepository = mock(DriverRiderRepository.class);
        ResultEnvelope<List<JobDto>> actualJobsList = (new JobController(
                new JobServiceImpl(jobRepository, clientRepository, driverRiderRepository, new MapperUtil(new ModelMapper()))))
                .getJobsList();
        assertEquals(200, actualJobsList.getCode().intValue());
        assertTrue(actualJobsList.isSuccess());
        assertNull(actualJobsList.getMetadata());
        assertNull(actualJobsList.getErrors());
        assertEquals(jobList, actualJobsList.getData());
        verify(jobRepository).findAll();
    }

    @Test
    void testGetJobById() throws AcmeException {
        Client client = new Client();
        client.setLastName("Doe");
        client.setEmail("jane.doe@example.org");
        client.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        client.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        client.setIsDeleted(true);
        client.setId(123L);
        client.setPhoneNumber("4105551212");
        client.setFirstName("Jane");

        DriverRider driverRider = new DriverRider();
        driverRider.setLastName("Doe");
        driverRider.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        driverRider.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        driverRider.setIsDeleted(true);
        driverRider.setId(123L);
        driverRider.setPhoneNumber("4105551212");
        driverRider.setFirstName("Jane");

        Job job = new Job();
        job.setClient(client);
        job.setDriverRider(driverRider);
        job.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        job.setDeliveryDate(LocalDate.ofEpochDay(1L));
        job.setDeliveryTime(LocalTime.of(1, 1));
        job.setJobReference("Job Reference");
        job.setDescription("The characteristics of someone or something");
        job.setLocation("Location");
        job.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        job.setIsDeleted(true);
        job.setId(123L);
        ArrayList<JobItem> jobItemList = new ArrayList<>();
        job.setJobItems(jobItemList);
        job.setStatus(Status.NEW);
        JobRepository jobRepository = mock(JobRepository.class);
        when(jobRepository.findById((Long) any())).thenReturn(Optional.of(job));
        ClientRepository clientRepository = mock(ClientRepository.class);
        DriverRiderRepository driverRiderRepository = mock(DriverRiderRepository.class);
        ResultEnvelope<List<JobDto>> actualJobById = (new JobController(
                new JobServiceImpl(jobRepository, clientRepository, driverRiderRepository, new MapperUtil(new ModelMapper()))))
                .getJobById(123L);
        assertEquals(200, actualJobById.getCode().intValue());
        assertTrue(actualJobById.isSuccess());
        assertNull(actualJobById.getMetadata());
        assertNull(actualJobById.getErrors());
        List<Object> data = Collections.singletonList(actualJobById.getData());

//        assertTrue(data instanceof JobDto);
        assertEquals(
                "[JobDto(id=123, jobReference=Job Reference, client=ClientDto(id=123, firstName=Jane, lastName=Doe,"
                        + " phoneNumber=4105551212, email=jane.doe@example.org), location=Location, description=The characteristics"
                        + " of someone or something, deliveryDate=1970-01-02, deliveryTime=01:01, status=NEW, driverRider"
                        + "=DriverRiderDto(id=123, firstName=Jane, lastName=Doe, phoneNumber=4105551212), jobItems=[])]",
                data.toString());
//        assertEquals("1970-01-02", ((JobDto) data).getDeliveryDate().toString());
//        assertEquals("The characteristics of someone or something", ((JobDto) data).getDescription());
//        assertEquals("Job Reference", ((JobDto) data).getJobReference());
//        assertEquals("Location", ((JobDto) data).getLocation());
//        assertEquals(Status.NEW, ((JobDto) data).getStatus());
//        assertEquals("01:01", ((JobDto) data).getDeliveryTime().toString());
//        assertEquals(123L, ((JobDto) data).getId().longValue());
//        assertEquals(jobItemList, ((JobDto) data).getJobItems());
//        DriverRiderDto driverRider1 = ((JobDto) data).getDriverRider();
//        assertEquals(123L, driverRider1.getId().longValue());
//        assertEquals("Jane", driverRider1.getFirstName());
//        ClientDto client1 = ((JobDto) data).getClient();
//        assertEquals(123L, client1.getId().longValue());
//        assertEquals("4105551212", client1.getPhoneNumber());
//        assertEquals("4105551212", driverRider1.getPhoneNumber());
//        assertEquals("Jane", client1.getFirstName());
//        assertEquals("Doe", client1.getLastName());
//        assertEquals("Doe", driverRider1.getLastName());
//        assertEquals("jane.doe@example.org", client1.getEmail());
//        verify(jobRepository).findById((Long) any());
    }


}

