package com.acme.controller;


import com.acme.model.Job;
import com.acme.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<Job> cerateJob(@RequestBody Job job){


        return ResponseEntity.ok(job);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Job>> getJobsList(){

        List<Job> allJobsList = jobService.getAllJobsList();


        return ResponseEntity.of(allJobsList);
    }
}
