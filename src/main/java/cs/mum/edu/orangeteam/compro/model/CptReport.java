package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.*;

import cs.mum.edu.orangeteam.compro.model.*;

import java.util.Date;

@Entity
public class CptReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date submittedDate;

	@Column(length =150)
	private String cptReport;
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	public CptReport() {
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public String getCptReport() {
		return cptReport;
	}

	public void setCptReport(String cptReport) {
		this.cptReport = cptReport;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
