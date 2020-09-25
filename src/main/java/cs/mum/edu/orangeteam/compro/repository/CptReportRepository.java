package cs.mum.edu.orangeteam.compro.repository;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CptReportRepository extends JpaRepository<CptReport, Long> {

}
