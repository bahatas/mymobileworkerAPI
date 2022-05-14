package com.acme.controller;


import com.acme.exception.AcmeException;
import com.acme.model.dto.JobDto;
import com.acme.model.ResultEnvelope;
import com.acme.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create jobs")
    public ResultEnvelope<JobDto> cerateJob(@RequestBody JobDto jobDto) throws AcmeException {
        JobDto saved = jobService.save(jobDto);
        return ResultEnvelope.ok(saved);
    }

    @GetMapping("/list")
    @Operation(summary = "Read all jobs")
    public ResultEnvelope<List<JobDto>> getJobsList(){

        List<JobDto> allJobsList = jobService.getAllJobsList();

        return ResultEnvelope.ok(allJobsList);
    }
    @GetMapping("/{jobId}")
    @Operation(summary = "Find job by id")
    public ResultEnvelope<List<JobDto>> getJobById(@PathVariable("jobId") Long id) throws AcmeException {

        JobDto jobById = jobService.getJobById(id);

        return ResultEnvelope.ok(jobById);
    }
}
