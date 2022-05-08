package com.acme.service;

import com.acme.enums.Status;
import com.acme.model.JobDto;
import com.acme.model.entity.Job;
import com.acme.repository.JobRepository;
import com.acme.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
        convert.setStatus(Status.NEW);
        Job save = jobRepository.save(convert);
        log.info("Job with reference "+save.getJobReference()+ "created");
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
