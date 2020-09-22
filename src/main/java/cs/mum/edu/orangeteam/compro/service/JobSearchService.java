package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface JobSearchService {

//    public JobSearchReport addCptReport(JobSearchReport jobSearchReport);
//    public JobSearchReport updateCptReport(JobSearchReport jobSearchReport);
//    public void deleteCptReport(Long id);
//    public JobSearchReport findCptReportById(Long id);
//    public Collection<JobSearchReport> findAll();
//    public List<JobSearchReport> getAllJobSearch();
	
	public List<JobSearchReport> getAllJobSearchReport();
	public JobSearchReport getJobSearchReportById(Long id);
	public JobSearchReport addJobSearchReport(JobSearchReport report);
	public JobSearchReport updateJobSearchReport(JobSearchReport report);
	public void deleteJobSearchReport(Long id);
}
