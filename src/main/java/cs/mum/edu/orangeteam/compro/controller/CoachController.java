package cs.mum.edu.orangeteam.compro.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import cs.mum.edu.orangeteam.compro.DTO.Student;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.service.CoachService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/coaches")
public class CoachController {

	@Autowired
	private CoachService coachService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getStudents")
	public List<Student> getStudentsName() {
		ResponseEntity<List<Student>> responseEntity = restTemplate.exchange("http://course-service/course/students",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
				});
		List<Student> students = responseEntity.getBody();
		return students;
	}


	@GetMapping("")
	public List<Coach> getAllCoaches() {
		return coachService.getAllCoaches();
	}

	@GetMapping("/{id}")
	public Coach getCoachById(@PathVariable("id") Long id) {
		return coachService.findCoachById(id);
	}

	@PostMapping("")
	public Coach addStudent(@RequestBody final Coach coach) {
		return coachService.addCoach(coach);
	}

	@PutMapping("")
	public Coach updateCoach(@RequestBody final Coach coach) {
		return coachService.updateCoach(coach);
	}

	@DeleteMapping("/{id}")
	public boolean deleteCoach(@PathVariable("id") Long id) {
		Coach coach = coachService.findCoachById(id);
		if(coach == null) return false;
		coachService.deleteCoach(id);
		return true;
	}

	@GetMapping("/cptreport")
	public List<CptReport> getAllCptReport(){
		return coachService.getAllCptReport();
	}
//	@GetMapping("/jobsearch")
//	public List<JobSearchReport> getAllJobSearch(){
//		return coachService.getAllJobSearch();
//	}


}
