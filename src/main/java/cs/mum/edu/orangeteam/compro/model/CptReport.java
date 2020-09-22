package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.*;

import cs.mum.edu.orangeteam.compro.model.*;

@Entity
//@DiscriminatorValue("CptReport")
public class CptReport extends Report {
	@Column(length =150)
	private String cptReport;
	@ManyToOne
	private Job job;
	
	public CptReport() {
		super();
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
		job.getCptreports().add(this);
	}


	public String getCptReport() {
		return cptReport;
	}

	public void setCptReport(String cptReport) {
		this.cptReport = cptReport;
	}
	
	
}
