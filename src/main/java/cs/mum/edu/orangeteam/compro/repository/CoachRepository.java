package cs.mum.edu.orangeteam.compro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.mum.edu.orangeteam.compro.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long>{

}
