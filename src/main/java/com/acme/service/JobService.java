package com.acme.service;

import com.acme.model.JobDto;

import java.util.List;

public interface JobService {


    List<JobDto> getAllJobsList();
    JobDto getJobById(Long id);
    JobDto save(JobDto jobDto);
    void delete(Long id);
    JobDto update(Long id,JobDto jobDto);

}
