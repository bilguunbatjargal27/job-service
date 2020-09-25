package cs.mum.edu.orangeteam.compro.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

//import cs.mum.edu.orangeteam.compro.DTO.Address;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cs.mum.edu.orangeteam.compro.AbstractTest;
import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.service.CoachService;

import java.util.Date;

public class CoachControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	// test getAll method
	@org.junit.Test
	public void getAllCoaches() throws Exception {
		String uri = "/coaches";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Coach[] coaches = super.mapFromJson(content, Coach[].class);
		
		assertTrue(coaches.length > 0);
	}

	@org.junit.Test
	    public void getCoachById() throws Exception {
	        String uri = "/coaches/1";
	        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

	        int status = mvcResult.getResponse().getStatus();
	        assertEquals(200, status);
	    }

	@org.junit.Test
	    public void addCoach() throws Exception {
	        String uri = "/coaches/add";
	        Coach coach = new Coach();
	        coach.setName("Blah2");
	        coach.setOffice("123");
	        coach.setResponsibilityDescription("12321321");
	        coach.setHiringDate(new Date());

	        String inputJson = super.mapToJson(coach);

	        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	                .contentType(MediaType.APPLICATION_JSON_VALUE)
	                .content(inputJson)).andReturn();

	        int status = mvcResult.getResponse().getStatus();

	        assertEquals(200, status);
	        String content = mvcResult.getResponse().getContentAsString();
	    }


	@org.junit.Test
	public void deleteCoach() throws Exception {
		String uri = "/coaches/delete/5";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Student is deleted successfully");
	}

//	@org.junit.Test
//	public void getAllStudentsByCoach() throws Exception {
//		String uri = "/coaches/studentsByCoachId/1";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Coach[] productlist = super.mapFromJson(content, Coach[].class);
//		assertTrue(productlist.length > 0);
//	}



//	    @Test
//	    public void createProductFailure() throws Exception {
//	        String uri = "/course/students/add";
//	        Student student = new Student();
//	        Address address = new Address();
//	        address.setState("AA");
//	        address.setStreet("MyStreet");
//	        address.setZipCode("ZipCode");
//	        address.setCity("CITY");
//	        student.setId(610000L);
//	        student.setName("");
//	        student.setAddress(address);
//	        student.setGPA(2);
//	        student.setEnrollmentDate(new Date());
	//
//	        String inputJson = super.mapToJson(student);
//	        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//	                .contentType(MediaType.APPLICATION_JSON_VALUE)
//	                .content(inputJson)).andReturn();
	//
//	        int status = mvcResult.getResponse().getStatus();
//	        assertEquals(400, status);
//	    }
	//
//	    @org.junit.Test
//	    public void updateCoach() throws Exception {
//	        String uri = "/coaches/update";
//	        Coach coach = new Coach();
//			coach.setId(1L);
//			coach.setName("Name");
//			coach.setHiringDate(new Date());
//	        String inputJson = super.mapToJson(coach);
//	        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//	                .contentType(MediaType.APPLICATION_JSON_VALUE)
//	                .content(inputJson)).andReturn();
//
//	        int status = mvcResult.getResponse().getStatus();
//	        assertEquals(200, status);
//	        String content = mvcResult.getResponse().getContentAsString();
//	        assertEquals(content, "Coach is updated successfully");
//	    }
	// @Test
//	    public void updateProductFailure() throws Exception {
//	        String uri = "/course/students/update";
//	        Student student = new Student();
//	        Address address = new Address();
//	        address.setState("AA");
//	        address.setStreet("MyStreet");
//	        address.setZipCode("ZipCode");
//	        address.setCity("CITY");
//	        student.setId(610000L);
//	        student.setName("Name");
//	        student.setAddress(address);
//	        student.setGPA(10);
//	        student.setEnrollmentDate(new Date());
//	        String inputJson = super.mapToJson(student);
//	        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//	                .contentType(MediaType.APPLICATION_JSON_VALUE)
//	                .content(inputJson)).andReturn();
	//
//	        int status = mvcResult.getResponse().getStatus();
//	        assertEquals(400, status);
//	    }
	//


//	@org.junit.Test
//	public void getAllStudentsByCoach() throws Exception {
//		String uri = "/coaches/studentsByCoachId/1";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Coach[] productlist = super.mapFromJson(content, Coach[].class);
//		assertTrue(productlist.length > 0);
//	}
//
//	@Test
//	public void getStudentsListByCoachId() throws Exception {
//		String uri = "/course/students/byCoach/1";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Coach[] productlist = super.mapFromJson(content, Coach[].class);
//		assertTrue(productlist.length > 0);
//	}
//

}
