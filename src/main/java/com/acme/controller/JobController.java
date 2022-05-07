package com.acme.controller;


import com.acme.model.JobDto;
import com.acme.model.ResultEnvelope;
import com.acme.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private JobService jobService;

    @PostMapping("/create")
    public ResultEnvelope<JobDto> cerateJob(@RequestBody JobDto jobDto){
        jobService.save(jobDto);
        return ResultEnvelope.ok(jobDto);
    }

    @GetMapping("/list")
    public ResultEnvelope<List<JobDto>> getJobsList(){

        List<JobDto> allJobsList = jobService.getAllJobsList();

        return ResultEnvelope.ok(allJobsList);
    }
    @GetMapping("/list2")
    public ResponseEntity<List<JobDto>> getJobsList2(){

        List<JobDto> allJobsList = jobService.getAllJobsList();



        return ResponseEntity.ok(allJobsList);
    }
}
