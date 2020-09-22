package cs.mum.edu.orangeteam.compro.service;

import java.util.List;

import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;

public interface CoachService {
	public List<Coach> getAllCoaches();
	public List<CptReport> getAllCptReport();
//	public List<JobSearchReport> getAllJobSearch();

}
