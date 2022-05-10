package com.acme.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.acme.enums.Status;
import com.acme.exception.AcmeException;
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
import com.acme.util.MapperUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JobServiceImpl.class})
@ExtendWith(SpringExtension.class)
class JobServiceImplTest {
    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private DriverRiderRepository driverRiderRepository;

    @MockBean
    private JobRepository jobRepository;

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @MockBean
    private MapperUtil mapperUtil;

    @Test
    void testGetAllJobsList() {
        when(this.jobRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.jobServiceImpl.getAllJobsList().isEmpty());
        verify(this.jobRepository).findAll();
    }

    @Test
    void testGetAllJobsList2() {
//        when(this.mapperUtil.convert((Object) any(), (Object) any())).thenReturn(new JobDto());


        Job job = new Job();
        job.setDeliveryDate(LocalDate.ofEpochDay(1L));
        job.setDeliveryTime(LocalTime.of(1, 1));
        job.setId(123L);
        job.setJobItems(new ArrayList<>());
        job.setStatus(Status.NEW);

        ArrayList<Job> jobList = new ArrayList<>();
        jobList.add(job);

        when(this.jobRepository.findAll()).thenReturn(jobList);
        assertEquals(1, this.jobServiceImpl.getAllJobsList().size());
        verify(this.mapperUtil).convert(any(), any());
        verify(this.jobRepository).findAll();
    }


    @Test
    void testGetJobById() throws AcmeException {

        Client client = new Client();
        DriverRider driverRider = new DriverRider();
        Job job = new Job();
        job.setClient(client);
        job.setDriverRider(driverRider);
        job.setDeliveryDate(LocalDate.ofEpochDay(1L));
        job.setDeliveryTime(LocalTime.of(1, 1));
        job.setId(123L);

        ArrayList<JobItem> jobItemList = new ArrayList<>();
        job.setJobItems(jobItemList);

        JobDto jobDto = new JobDto();

        when(this.jobRepository.findById(123L)).thenReturn(Optional.of(job));
        when(this.mapperUtil.convert(job, new JobDto())).thenReturn(new JobDto());


        assertNotNull(this.jobServiceImpl.getJobById(123L));
        verify(this.mapperUtil).convert(any(), any());
        verify(this.jobRepository).findById(123L);
        assertEquals(jobDto, this.jobServiceImpl.getJobById(123L));
    }

    @Test
    void testGetJobById2() throws AcmeException {
        when(this.mapperUtil.convert((Object) any(), (Object) any())).thenReturn(null);
        Job job = new Job();
        job.setId(123L);
        ArrayList<JobItem> jobItemList = new ArrayList<>();
        job.setJobItems(jobItemList);
        when(this.jobRepository.findById((Long) any())).thenReturn(Optional.of(job));
        assertNull(this.jobServiceImpl.getJobById(123L));
        verify(this.mapperUtil).convert((Object) any(), (Object) any());
        verify(this.jobRepository).findById((Long) any());
        assertEquals(jobItemList, this.jobServiceImpl.getAllJobsList());
    }

//    @Test
//    void testSave() throws AcmeException {
//        DriverRiderDto driverRiderDto = new DriverRiderDto();
//        driverRiderDto.setId(123L);
//
//        ClientDto clientDto = new ClientDto();
//        clientDto.setId(123L);
//
//        JobDto jobDtotest = new JobDto();
//        jobDtotest.setDriverRider(driverRiderDto);
//        jobDtotest.setClient(clientDto);
//        jobDtotest.setId(123L);
//
//
//        Client client1 = new Client();
//        client1.setId(123L);
//
//        DriverRider driverRider1 = new DriverRider();
//        driverRider1.setId(123L);
//
//        Job job = new Job();
//        job.setId(123L);
//        job.setDriverRider(driverRider1);
//        job.setClient(client1);
//        ClientRepository clientRepository = mock(ClientRepository.class);
//        DriverRiderRepository driverRiderRepository = mock(DriverRiderRepository.class);
//
//        when(clientRepository.findById(123L)).thenReturn(Optional.of(client1));
//        when(driverRiderRepository.findById((Long) any())).thenReturn(Optional.of(driverRider1));
//
//        JobRepository jobRepository = mock(JobRepository.class);
//        when(jobRepository.save((Job) any())).thenReturn(job);
//
//        JobDto actualSaveResult = jobServiceImpl.save(jobDtotest);
//
//        assertEquals(
//                "JobDto(id=123, , client=ClientDto(id=123), driverRider"
//                        + "=DriverRiderDto(id=123), jobItems=[])",
//                actualSaveResult.toString());
//        assertEquals(Status.NEW, actualSaveResult.getStatus());
//        assertEquals(123L, actualSaveResult.getId().longValue());
//
//        verify(jobRepository).save((Job) any());
//        verify(clientRepository).findById((Long) any());
//        verify(driverRiderRepository).findById((Long) any());
//
//    }


    @Test
    void testDelete() {
        Client client = new Client();
        client.setId(123L);


        DriverRider driverRider = new DriverRider();
        driverRider.setId(123L);


        Job job = new Job();
        job.setClient(client);
        job.setDriverRider(driverRider);
        job.setId(123L);
        ArrayList<JobItem> jobItemList = new ArrayList<>();


        when(this.jobRepository.save((Job) any())).thenReturn(job);
        when(this.jobRepository.findById((Long) any())).thenReturn(Optional.of(job));
        this.jobServiceImpl.delete(123L);
        verify(this.jobRepository).findById((Long) any());
        verify(this.jobRepository).save((Job) any());

    }



//    @Test
//    void testUpdate() throws AcmeException {
//        Client client = new Client();
//        client.setId(123L);
//
//        DriverRider driverRider = new DriverRider();
//        driverRider.setId(123L);
//
//        Job job = new Job();
//        job.setClient(client);
//        job.setDriverRider(driverRider);
//        job.setId(123L);
//
//        JobRepository jobRepository = mock(JobRepository.class);
//
//        when(jobRepository.findById(123L)).thenReturn(Optional.of(job));
//        when(jobRepository.save((Job) any())).thenReturn(job);
//        JobDto jobDto = new JobDto();
//        jobDto.setId(123L);
//        JobDto actualUpdateResult = jobServiceImpl.update(jobDto);
//
//        assertEquals(123L, actualUpdateResult.getId().longValue());
//        verify(jobRepository).findById((Long) any());
//        verify(jobRepository).save((Job) any());
//
//    }

}

