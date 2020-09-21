package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @PostMapping("/add")
    public Job addJob(@RequestBody final Job job){
        return jobService.addJob(job);
    }

    @PutMapping("/update")
    public Job updateJob(@RequestBody final Job job){
        return jobService.updateJob(job);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteJob(@PathVariable("id") Long id){
        jobService.deleteJob(id);
        return true;
    }
}
