package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.repository.JobSearchRepository;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import cs.mum.edu.orangeteam.compro.service.JobSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class JobSearchImpl implements JobSearchService {

    @Autowired
    private JobSearchRepository jobSearchRepository;

    @Override
    public List<JobSearchReport> getAllJobSearchReport() {

        return jobSearchRepository.findAll();
    }

    @Override
    public JobSearchReport getJobSearchReportById(Long id) {
        if (jobSearchRepository.findById(id).isPresent()) {
            return jobSearchRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public JobSearchReport addJobSearchReport(JobSearchReport report) {

        return jobSearchRepository.save(report);
    }

    @Override
    public JobSearchReport updateJobSearchReport(JobSearchReport report) {
        return jobSearchRepository.save(report);
    }

    @Override
    public void deleteJobSearchReport(Long id) {
        jobSearchRepository.existsById(id);
    }


}
