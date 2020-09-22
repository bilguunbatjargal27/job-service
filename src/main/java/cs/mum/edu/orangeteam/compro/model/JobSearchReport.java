package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("JobSearchReport")
public class JobSearchReport extends Report{
	@Column(length =100)
	private String jobSearchReport;

	public JobSearchReport() {
		super();
	}

	public String getJobSearchReport() {
		return jobSearchReport;
	}

	public void setJobSearchReport(String jobSearchReport) {
		this.jobSearchReport = jobSearchReport;
	}

	@Override
	public String toString() {
		return "JobSearchReport [jobSearchReport=" + jobSearchReport + ", getJobSearchReport()=" + getJobSearchReport()
				+ "]";
	}	
	
}
