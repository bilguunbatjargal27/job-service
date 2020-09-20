package cs.mum.edu.orangeteam.compro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.mum.edu.orangeteam.compro.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long>{

}
