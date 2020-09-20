package cs.mum.edu.orangeteam.compro.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import cs.mum.edu.orangeteam.compro.model.Address;
@Entity
public class Coach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date hiringDate;
	private String office;
	
	@Embedded
	private Address address;
	@Column(length = 120)
	private String responsibilityDescription;
	
	// from course-service
	//private List<Student> students = new ArrayList<>();
	
	@OneToMany(mappedBy = "coach")
	private List<Job> jobs = new ArrayList<>();

	public Coach() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getResponsibilityDescription() {
		return responsibilityDescription;
	}

	public void setResponsibilityDescription(String responsibilityDescription) {
		this.responsibilityDescription = responsibilityDescription;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Coach [id=" + id + ", name=" + name + ", hiringDate=" + hiringDate + ", office=" + office + ", address="
				+ address + ", responsibilityDescription=" + responsibilityDescription + ", jobs=" + jobs + "]";
	}

	
}
