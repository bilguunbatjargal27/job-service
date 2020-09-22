package cs.mum.edu.orangeteam.compro.DAO;

import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSearchRepository extends JpaRepository<JobSearchReport,Long> {
}
