package cs.mum.edu.orangeteam.compro.model;

import java.util.Date;

import javax.persistence.*;

import cs.mum.edu.orangeteam.compro.model.*;

@Entity

public class CptReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date submittedDate;


	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@Column(length =150)
	private String cptReport;
	@ManyToOne
	private Job job;
	
	public CptReport() {
		super();
	}

//	public Job getJob() {
//		return job;
//	}

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

	public Job getJob() {
		return job;
	}

//	public void setJob(Job job) {
//		this.job = job;
//	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "CptReport{" +
				"id=" + id +
				", submittedDate=" + submittedDate +
				", dueDate=" + dueDate +
				", cptReport='" + cptReport + '\'' +
				", job=" + job +
				'}';
	}

}
