package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job addJob(Job job);

    Job updateJob(Job job);

    void deleteJob(Long id);


}
