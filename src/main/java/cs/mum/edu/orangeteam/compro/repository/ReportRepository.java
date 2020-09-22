package cs.mum.edu.orangeteam.compro.repository;

import cs.mum.edu.orangeteam.compro.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
