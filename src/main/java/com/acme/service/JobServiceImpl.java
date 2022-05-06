package com.acme.service;

import com.acme.model.JobDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Override
    public List<JobDto> getAllJobsList() {
        return null;
    }

    @Override
    public JobDto getJobById(Long id) {
        return null;
    }

    @Override
    public JobDto save(JobDto jobDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public JobDto update(JobDto jobDto) {
        return null;
    }
}
