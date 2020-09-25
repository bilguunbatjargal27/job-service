package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.AbstractTest;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.service.JobService;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import cs.mum.edu.orangeteam.compro.AbstractComproComponentTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


public class JobControllerTest extends AbstractTest {

    @Autowired
    private JobService jobService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @org.junit.Test
    public void getAllJobs() throws Exception {
        String uri = "/jobs";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Job[] jobs1 = super.mapFromJson(content, Job[].class);
        assertTrue(jobs1.length > 0);

    }



    @org.junit.Test
    public void getJobById() throws Exception{
        String uri = "/jobs/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @org.junit.Test
    public void addJob() throws Exception{
        String uri = "/jobs/add";
        Job job = new Job();
        job.setStartDate(new Date());
        job.setTitle("Ati");



        String inputJson = super.mapToJson(job);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    @org.junit.Test
    public void updateJob() throws Exception{
        String uri = "/jobs/update";
        Job job = new Job();
        job.setStartDate(new Date());
        job.setId(1L);
//        job.setAttendType(AttendType.IN_CLASS);

        String inputJson = super.mapToJson(job);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Job is updated successfully");
    }

    @org.junit.Test
    public void deleteJob() throws Exception{
        String uri = "/jobs/delete/3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Job is deleted successfully");
    }
}