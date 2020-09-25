package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import cs.mum.edu.orangeteam.compro.service.JobSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobsearchreports")
public class JobSearchReportController {

    @Autowired
    private JobSearchService jobSearchService;

    @GetMapping("")
    public ResponseEntity<?> getAllStundets(){
        List<JobSearchReport> jobSearchReports = (List<JobSearchReport>) jobSearchService.getAllJobSearchReport();
        return ResponseEntity.ok(jobSearchReports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        JobSearchReport jobSearchService1 = jobSearchService.getJobSearchReportById(id);
        return ResponseEntity.ok(jobSearchService1);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody final JobSearchReport jobSearchReport, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        JobSearchReport job = jobSearchService.addJobSearchReport(jobSearchReport);
        return ResponseEntity.status(HttpStatus.OK).body(job);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        JobSearchReport student = jobSearchService.getJobSearchReportById(id);
        if(student == null) return ResponseEntity.badRequest().body("There is no job search has an id equal to" + id);
        jobSearchService.deleteJobSearchReport(id);
        return ResponseEntity.status(HttpStatus.OK).body("job search is deleted successfully");
    }

}
