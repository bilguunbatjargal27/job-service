package cs.mum.edu.orangeteam.compro.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private double salary;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@OneToMany(mappedBy = "job")
	private List<Report> cptReports = new ArrayList<>();
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Report> getCptReports() {
		return cptReports;
	}

	public void setCptReports(List<Report> cptReports) {
		this.cptReports = cptReports;
	}



	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", title='" + title + '\'' +
				", salary=" + salary +
				", startDate=" + startDate +
				", cptReports=" + cptReports +

				'}';
	}
}
