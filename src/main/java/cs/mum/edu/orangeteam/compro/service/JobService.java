package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;

import java.util.List;

public interface JobService {
    public List<Job> getAllJobs();
    public Job getJobById(Long id);
    public Job addJob(Job job);
    public Job updateJob(Job job);
    public void deleteJob(Long id);
//    public List<CptReport> getAllCptReport();
//    public List<JobSearchReport> getAllCptReport();


}
