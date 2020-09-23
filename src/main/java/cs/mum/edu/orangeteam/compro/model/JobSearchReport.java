package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class JobSearchReport{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date submittedDate;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@Column(length =100)
	private String jobSearchReport;

	public JobSearchReport() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getJobSearchReport() {
		return jobSearchReport;
	}

	public void setJobSearchReport(String jobSearchReport) {
		this.jobSearchReport = jobSearchReport;
	}
}
