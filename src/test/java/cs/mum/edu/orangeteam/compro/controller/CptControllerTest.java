package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.AbstractTest;
import cs.mum.edu.orangeteam.compro.model.Coach;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.service.JobService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CptControllerTest extends AbstractTest {

    @Autowired
    private JobService jobService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @org.junit.Test
    public void getAllCptReport() throws Exception {
        String uri = "/cptreports";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CptReport[] jobs1 = super.mapFromJson(content, CptReport[].class);
        assertTrue(jobs1.length > 0);

    }



    @org.junit.Test
    public void getCptReportById() throws Exception{
        String uri = "/cptreports/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @org.junit.Test
    public void addCptReport() throws Exception{
        String uri = "/cptreports/add";
        CptReport cpt = new CptReport();
        cpt.setDueDate(new Date());
        cpt.setCptReport("Working......");
//        job.setCoach(Coach.IN_CLASS);

        String inputJson = super.mapToJson(cpt);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    @org.junit.Test
    public void updateCptReport() throws Exception{
        String uri = "/cptreports/update";
        CptReport cpt = new CptReport();
        cpt.setDueDate(new Date());
        cpt.setId(1L);
//        job.setAttendType(AttendType.IN_CLASS);

        String inputJson = super.mapToJson(cpt);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Job is updated successfully");
    }

}