package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.repository.CptReportRepository;
import cs.mum.edu.orangeteam.compro.repository.JobRepository;
import cs.mum.edu.orangeteam.compro.repository.JobSearchRepository;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import cs.mum.edu.orangeteam.compro.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CptReportRepository cptReportRepository;
    @Autowired
    private JobSearchRepository jobSearchRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        if (jobRepository.findById(id).isPresent())
            return jobRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);

    }

    public List<CptReport> getAllCptReport() {

        return cptReportRepository.findAll();
    }

    public List<JobSearchReport> getAllJobSearchReport() {
        return jobSearchRepository.findAll();
    }


}
