package cs.mum.edu.orangeteam.compro.service;

import java.util.List;

import cs.mum.edu.orangeteam.compro.model.Coach;

public interface CoachService {
	public List<Coach> getAllCoaches();
	public Coach findCoachById(Long id);
	public Coach addCoach(Coach coach);
	public Coach updateCoach(Coach coach);
	public void deleteCoach(Long id);
	
	

}
