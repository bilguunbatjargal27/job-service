package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import cs.mum.edu.orangeteam.compro.model.*;

@Entity
//@DiscriminatorValue("CptReport")
public class CptReport extends Report {
	@Column(length =150)
	private String cptReport;
	
	public CptReport() {
		super();
	}

	public String getCptReport() {
		return cptReport;
	}

	public void setCptReport(String cptReport) {
		this.cptReport = cptReport;
	}
	
	
}
