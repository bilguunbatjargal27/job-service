package cs.mum.edu.orangeteam.compro;

import cs.mum.edu.orangeteam.compro.model.Address;
import cs.mum.edu.orangeteam.compro.model.Coach;
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

}
