package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Job;

import java.util.List;

public interface JobService {
    public List<Job> getAllJobs();
    public Job getJobById(Long id);
    public Job addJob(Job job);



}
