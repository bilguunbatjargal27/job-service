package cs.mum.edu.orangeteam.compro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.orangeteam.compro.DAO.CoachRepository;
import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.service.CoachService;

@Service
@Transactional
public class CoachServiceImpl implements CoachService{
	
	@Autowired
	private CoachRepository coachRepository;
	
	@Override
	public List<Coach> getAllCoaches() {
		
		return coachRepository.findAll();
	}

}
