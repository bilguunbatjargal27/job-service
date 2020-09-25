package cs.mum.edu.orangeteam.compro.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.validation.Valid;
import cs.mum.edu.orangeteam.compro.DTO.Student;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
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


	@GetMapping("")
	public ResponseEntity<?> getAllCoaches() {
		List<Coach> coaches = (List<Coach>) coachService.getAllCoaches();
		return ResponseEntity.ok(coaches);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCoachById(@PathVariable("id") Long id) {
		Coach coach = coachService.findCoachById(id);
		return ResponseEntity.ok(coach);
	}

	@PostMapping(value = "/add")
	//@PostMapping("")
	public ResponseEntity<?> addCoach(@Valid @RequestBody final Coach coach, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		Coach coach1 = coachService.addCoach(coach);
		return ResponseEntity.status(HttpStatus.OK).body(coach1);
	}

	@PutMapping("/update")
	//@PutMapping("")
	public ResponseEntity<?> updateCoach(@Valid @RequestBody final Coach coach, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		Coach coach1 = coachService.updateCoach(coach);
		return ResponseEntity.status(HttpStatus.OK).body(coach1);
	}

	@DeleteMapping("/delete/{id}")
	//@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCoach(@PathVariable("id") Long id) {
		Coach coach = coachService.findCoachById(id);
		if (coach == null)
			return ResponseEntity.badRequest().body("There is no student has an id equal to" + id);
		coachService.deleteCoach(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student is deleted successfully");
	}

	
	// use cases
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		String url = "http://course-service/course/students";
		ResponseEntity<List<Student>> students = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Student>>() {
				});
		List<Student> list = students.getBody();
		return list;
	}

	@GetMapping("/studentsByCoachId/{id}")
	public List<Student> getAllStudentsByCoach(@PathVariable("id") Long id) {
		String url = "http://course-service/course/students/bycoach/";
		ResponseEntity<List<Student>> students = restTemplate.exchange(url + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Student>>() {
				});
		List<Student> list = students.getBody();
		return list;
	}

	@GetMapping("/assignStudent/{coachId}/{stuId}")
	public ResponseEntity<?> getCoachById(@PathVariable Long coachId, @PathVariable Long stuId) {
		String url = "http://course-service/course/students";
		ResponseEntity<Student> responseEntity = restTemplate.exchange(url + "/" + stuId, HttpMethod.GET, null,
				new ParameterizedTypeReference<Student>() {
				});
		Student student = responseEntity.getBody();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");

		student.setCoach(coachId);

		HttpEntity<?> httpEntity = new HttpEntity<Student>(student, headers);
		restTemplate.exchange(url + "/update", HttpMethod.PUT, httpEntity, Student.class);
		return ResponseEntity.ok("Successfully assign student");
	}

		
//	
//
//	@GetMapping("")
//	public List<Coach> getAllCoaches() {
//		return coachService.getAllCoaches();
//	}

//	@GetMapping("/{id}")
//	public Coach getCoachById(@PathVariable("id") Long id) {
//		return coachService.findCoachById(id);
//	}

//	@PostMapping("")
//	public Coach addStudent(@RequestBody final Coach coach) {
//		return coachService.addCoach(coach);
//	}	
//
//	@PutMapping("")
//	public Coach updateCoach(@RequestBody final Coach coach) {
//		return coachService.updateCoach(coach);
//	}

	//@DeleteMapping("/{id}")
//	public boolean deleteCoach(@PathVariable("id") Long id) {
//		Coach coach = coachService.findCoachById(id);
//		if (coach == null)
//			return false;
//		coachService.deleteCoach(id);
//		return true;
//	}
	
//	@GetMapping("/cptreport")
//	public List<CptReport> getAllCptReport() {
//		return coachService.getAllCptReport();
//	}
	
	
//	@GetMapping("/jobsearch")
//	public List<JobSearchReport> getAllJobSearch(){
//		return coachService.getAllJobSearch();
//	}

}
