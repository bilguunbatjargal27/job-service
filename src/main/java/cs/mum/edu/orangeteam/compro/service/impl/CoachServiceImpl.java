package cs.mum.edu.orangeteam.compro.service.impl;

import java.util.List;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.orangeteam.compro.DAO.CoachRepository;
import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.service.CoachService;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachRepository coachRepository;

	@Autowired
	private JobServiceImpl jobService;

	@Override
	public List<Coach> getAllCoaches() {

		return coachRepository.findAll();
	}

	@Override
	public Coach findCoachById(Long id) {
		if (coachRepository.findById(id).isPresent())
			return coachRepository.findById(id).get();
		else
			return null;
	}

	@Override
	public Coach addCoach(Coach coach) {		
		return coachRepository.save(coach);
	}

	@Override
	public Coach updateCoach(Coach coach) {		
		return coachRepository.save(coach);
	}

	@Override
	public void deleteCoach(Long id) {
		coachRepository.existsById(id);
		
	}		
	
	public List<CptReport> getAllCptReport(){
		return jobService.getAllCptReport();
	}

}
