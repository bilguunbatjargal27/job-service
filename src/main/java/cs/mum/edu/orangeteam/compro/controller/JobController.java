package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;


    @GetMapping("")
    public ResponseEntity<?> getAllJobs(){
        List<Job> jobs = (List<Job>) jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }


        @GetMapping("/{id}")
        public ResponseEntity<?> getJobById(@PathVariable("id") Long id){
            Job jobs = jobService.getJobById(id);
            return ResponseEntity.ok(jobs);
        }


        @PostMapping(value = "/add")
        public ResponseEntity<?> addJob(@Valid @RequestBody final Job jobs, BindingResult bindingResult){
            if(bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
            }
            Job job = jobService.addJob(jobs);
            return ResponseEntity.status(HttpStatus.OK).body(job);
        }


    @PutMapping("/update")
    public ResponseEntity<?> updateJob(@Valid @RequestBody final Job job, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Job job1 = jobService.updateJob(job);
        return ResponseEntity.status(HttpStatus.OK).body(job1);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Long id){
        Job job = jobService.getJobById(id);
        if(job == null) return ResponseEntity.badRequest().body("There is no job has an id equal to" + id);
        jobService.deleteJob(id);
        return ResponseEntity.status(HttpStatus.OK).body("Job is deleted successfully");
    }

}
