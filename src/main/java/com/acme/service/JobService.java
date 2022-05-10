package com.acme.service;

import com.acme.exception.AcmeException;
import com.acme.model.dto.JobDto;

import java.util.List;

public interface JobService {


    List<JobDto> getAllJobsList();
    JobDto getJobById(Long id) throws AcmeException;
    JobDto save(JobDto jobDto) throws AcmeException;
    void delete(Long id);
    JobDto update(JobDto jobDto) throws AcmeException;

}
