package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import cs.mum.edu.orangeteam.compro.service.JobSearchService;
import cs.mum.edu.orangeteam.compro.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobsearchreports")
public class JobSearchReportController {

    @Autowired
    private JobSearchService jobSearchService;

    @GetMapping("")
	public List<JobSearchReport> getAllJobSearchReport(){
        return (List<JobSearchReport>) jobSearchService.getAllJobSearchReport();        
    }

    @GetMapping("/{id}")
    public JobSearchReport getJobSearchReportById(@PathVariable("id") Long id){
        return jobSearchService.getJobSearchReportById(id);
    }


    @PostMapping("/add")
    public JobSearchReport addJobSearchReport(@RequestBody final JobSearchReport report){
        return jobSearchService.addJobSearchReport(report);
    }

    @PutMapping("/update")
    public JobSearchReport updateJobSearchReport(@RequestBody final JobSearchReport report){
        return jobSearchService.addJobSearchReport(report);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteJobSearchReport(@PathVariable("id") Long id){
    	JobSearchReport report = jobSearchService.getJobSearchReportById(id);
    	if(report == null) return false;
    	jobSearchService.deleteJobSearchReport(id);
        return true;
    }
}
