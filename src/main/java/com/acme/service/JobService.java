package com.acme.service;

import com.acme.model.Job;

import java.util.List;

public interface JobService {


    List<Job> getAllJobsList();
    Job getJobById(Long id);
    Job save(Job job);
    void delete(Long id);
    Job update(Job job);

}
