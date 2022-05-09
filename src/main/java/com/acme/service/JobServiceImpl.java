package com.acme.service;

import com.acme.enums.Status;
import com.acme.exception.AcmeException;
import com.acme.model.dto.JobDto;
import com.acme.model.entity.Client;
import com.acme.model.entity.DriverRider;
import com.acme.model.entity.Job;
import com.acme.repository.ClientRepository;
import com.acme.repository.DriverRiderRepository;
import com.acme.repository.JobRepository;
import com.acme.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private ClientRepository clientRepository;
    private DriverRiderRepository driverRiderRepository;
    private MapperUtil mapperUtil;

    public JobServiceImpl(JobRepository jobRepository, ClientRepository clientRepository,
                          DriverRiderRepository driverRiderRepository, MapperUtil mapperUtil) {
        this.jobRepository = jobRepository;
        this.clientRepository = clientRepository;
        this.driverRiderRepository = driverRiderRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<JobDto> getAllJobsList() {

        List<Job> all = jobRepository.findAll();
        return all.stream().map(each->mapperUtil.convert(each, new JobDto())).collect(Collectors.toList());

    }

    @Override
    public JobDto getJobById(Long id) throws AcmeException {

        Job job = jobRepository.findById(id).get();
        if (job == null) {
            throw new AcmeException("There is no defined job with this id "+id);
        }
        return mapperUtil.convert(job,new JobDto());
    }

    @Override
    public JobDto save(JobDto jobDto) {
        System.out.println("jobDto.toString() = " + jobDto.toString());


        Client client = clientRepository.findById(jobDto.getClient().getId()).get();
        DriverRider driverRider = driverRiderRepository.findById(jobDto.getDriverRider().getId()).get();
        log.info("save method called");
        Job convert = mapperUtil.convert(jobDto, new Job());
        convert.setStatus(Status.NEW);
        convert.setClient(client);
        convert.setDriverRider(driverRider);
        Job save = jobRepository.save(convert);
        log.info("Job with reference "+save.getJobReference()+ "created");
        JobDto convert1 = mapperUtil.convert(save, new JobDto());
        return convert1;

    }

    @Override
    public void delete(Long id) {

        Job job = jobRepository.findById(id).orElseThrow();
        job.setIsDeleted(true);
        jobRepository.save(job);


    }

    @Override
    public JobDto update(Long id,JobDto jobDto) {
        Optional<Job> byId = jobRepository.findById(id);
        Job convert = mapperUtil.convert(jobDto, new Job());
        convert.setId(id);
        jobRepository.save(convert);
        return mapperUtil.convert(convert,new JobDto());

    }
}
