package cs.mum.edu.orangeteam.compro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.service.CoachService;

@RestController
@RequestMapping("/")
public class CoachController {
	
	@Autowired
	private CoachService coachService;
	
	@GetMapping("coaches")
	public List<Coach> getAllCoaches(){
		return coachService.getAllCoaches();
	}	

}
