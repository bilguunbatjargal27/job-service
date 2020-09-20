package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("JobSearchReport")
public class JobSearchReport extends Report{
	@Column(length =100)
	private String jobSearchReport;
}
