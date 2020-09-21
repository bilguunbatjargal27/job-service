package cs.mum.edu.orangeteam.compro.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.service.CoachService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class CoachController {
	
	@Autowired
	private CoachService coachService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("coaches")
	public List<Coach> getAllCoaches(){
		return coachService.getAllCoaches();
	}
	@GetMapping("getStudents")
	public List<String> getStudentsName(){
//		ResponseEntity<List<String>> names = restTemplate.
//				exchange("http://localhost:8001/course/students/getNames", HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});

		ResponseEntity<List<String>> names = restTemplate.
				exchange("http://course-service/course/students/getNames", HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
		List<String> testnames = names.getBody();
		return testnames;
	}

}
