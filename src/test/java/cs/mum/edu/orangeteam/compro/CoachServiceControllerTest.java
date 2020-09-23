package cs.mum.edu.orangeteam.compro;

import cs.mum.edu.orangeteam.compro.model.Address;
import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.model.Job;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CoachServiceControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    // test getAll method
    @Test
    public void getCoachList() throws Exception {
        String uri = "/coaches";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Coach[] coaches = super.mapFromJson(content, Coach[].class);
        assertTrue(coaches.length > 0);
    }

    @Test
    public void getStudentById() throws Exception {
        String uri = "/course/students/610000";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void createCoachSuccessfully() throws Exception {
        String uri = "/coach/add";

        Coach coach = new Coach();

        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");

        coach.setId(1L);
        coach.setName("Blah2");
        coach.setAddress(address);
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
//
//    @Test
//    public void createProductFailure() throws Exception {
//        String uri = "/course/students/add";
//        Student student = new Student();
//        Address address = new Address();
//        address.setState("AA");
//        address.setStreet("MyStreet");
//        address.setZipCode("ZipCode");
//        address.setCity("CITY");
//        student.setId(610000L);
//        student.setName("");
//        student.setAddress(address);
//        student.setGPA(2);
//        student.setEnrollmentDate(new Date());
//
//        String inputJson = super.mapToJson(student);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(400, status);
//    }
//
//    @Test
//    public void updateProductSuccessfully() throws Exception {
//        String uri = "/course/students/update";
//        Student student = new Student();
//        Address address = new Address();
//        address.setState("AA");
//        address.setStreet("MyStreet");
//        address.setZipCode("ZipCode");
//        address.setCity("CITY");
//        student.setId(610000L);
//        student.setName("Name");
//        student.setAddress(address);
//        student.setGPA(2);
//        student.setEnrollmentDate(new Date());
//        String inputJson = super.mapToJson(student);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Student is updated successfully");
//    }
//   @Test
//    public void updateProductFailure() throws Exception {
//        String uri = "/course/students/update";
//        Student student = new Student();
//        Address address = new Address();
//        address.setState("AA");
//        address.setStreet("MyStreet");
//        address.setZipCode("ZipCode");
//        address.setCity("CITY");
//        student.setId(610000L);
//        student.setName("Name");
//        student.setAddress(address);
//        student.setGPA(10);
//        student.setEnrollmentDate(new Date());
//        String inputJson = super.mapToJson(student);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(400, status);
//    }
//
//    @Test
//    public void deleteProduct() throws Exception {
//        String uri = "/course/students/delete/610000";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Student is deleted successfully");
//    }
//
//    @Test
//    public void getStudentsListByTmConstuctorId() throws Exception {
//        String uri = "/course/students/bytminstructor/1";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Student[] productlist = super.mapFromJson(content, Student[].class);
//        assertTrue(productlist.length > 0);
//    }
//    @Test
//    public void getStudentsListByCoachId() throws Exception {
//        String uri = "/course/students/byCoach/1";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Student[] productlist = super.mapFromJson(content, Student[].class);
//        assertTrue(productlist.length > 0);
//    }
//    @Test
//    public void getStudentsListByJobId() throws Exception {
//        String uri = "/course/students/byjob/1";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Student[] productlist = super.mapFromJson(content, Student[].class);
//        assertTrue(productlist.length > 0);
//    }


}
