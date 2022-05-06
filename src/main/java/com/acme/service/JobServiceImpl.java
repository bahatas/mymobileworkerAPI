package com.acme.service;

import com.acme.model.JobDto;
import com.acme.model.entity.Job;
import com.acme.repository.JobRepository;
import com.acme.util.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private MapperUtil mapperUtil;

    public JobServiceImpl(JobRepository jobRepository, MapperUtil mapperUtil) {
        this.jobRepository = jobRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<JobDto> getAllJobsList() {

        List<Job> all = jobRepository.findAll();
        return all.stream().map(each->mapperUtil.convert(each, new JobDto())).collect(Collectors.toList());

    }

    @Override
    public JobDto getJobById(Long id) {
        Optional<Job> byId = jobRepository.findById(id);
        return mapperUtil.convert(byId,new JobDto());
    }

    @Override
    public JobDto save(JobDto jobDto) {
        Job convert = mapperUtil.convert(jobDto, new Job());
        Job save = jobRepository.save(convert);
        return mapperUtil.convert(save,new JobDto());

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
