package com.acme.controller;


import com.acme.model.JobDto;
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
    public ResponseEntity<JobDto> cerateJob(@RequestBody JobDto jobDto){


        return ResponseEntity.ok(jobDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<JobDto>> getJobsList(){

        List<JobDto> allJobsList = jobService.getAllJobsList();



        return ResponseEntity.of(allJobsList);
    }
}
