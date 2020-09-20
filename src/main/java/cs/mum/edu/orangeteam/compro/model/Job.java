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
	
	@ManyToOne
	//@JoinColumn(name)
	private Coach coach;

}
