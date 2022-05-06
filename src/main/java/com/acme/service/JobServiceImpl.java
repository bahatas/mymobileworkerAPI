package com.acme.service;

import com.acme.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Override
    public List<Job> getAllJobsList() {
        return null;
    }

    @Override
    public Job getJobById(Long id) {
        return null;
    }

    @Override
    public Job save(Job job) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Job update(Job job) {
        return null;
    }
}
