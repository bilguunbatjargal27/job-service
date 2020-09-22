package cs.mum.edu.orangeteam.compro.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.*;

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
	private List<Report> reports = new ArrayList<>();
	
	@ManyToOne
	//@JoinColumn(name)
	private Coach coach;
	
	private List<CptReport> cptreports = new ArrayList<>();
	//---------------------------------------
//	private CptReport cptReport;

	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	public List<CptReport> getCptreports() {
		return cptreports;
	}

	public void setCptreports(List<CptReport> cptreports) {
		this.cptreports = cptreports;
	}

	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", title='" + title + '\'' +
				", salary=" + salary +
				", startDate=" + startDate +
				", reports=" + reports +
				", cptReports=" + cptreports +
				'}';
	}
}
