package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface JobSearchService {

	List<JobSearchReport> getAllJobSearchReport();
	JobSearchReport getJobSearchReportById(Long id);
	JobSearchReport addJobSearchReport(JobSearchReport report);
	JobSearchReport updateJobSearchReport(JobSearchReport report);
	void deleteJobSearchReport(Long id);
}
