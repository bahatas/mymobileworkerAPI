package com.acme.controller;


import com.acme.exception.AcmeException;
import com.acme.model.dto.JobDto;
import com.acme.model.ResultEnvelope;
import com.acme.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/create")
    public ResultEnvelope<JobDto> cerateJob(@RequestBody JobDto jobDto){
        JobDto saved = jobService.save(jobDto);
        return ResultEnvelope.ok(saved);
    }

    @GetMapping("/list")
    public ResultEnvelope<List<JobDto>> getJobsList(){

        List<JobDto> allJobsList = jobService.getAllJobsList();

        return ResultEnvelope.ok(allJobsList);
    }
    @GetMapping("/{jobId}")
    public ResultEnvelope<List<JobDto>> getJobById(@PathVariable("jobId") Long id) throws AcmeException {

        JobDto jobById = jobService.getJobById(id);

        return ResultEnvelope.ok(jobById);
    }
}
