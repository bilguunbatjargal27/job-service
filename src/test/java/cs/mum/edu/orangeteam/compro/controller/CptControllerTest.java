package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.AbstractTest;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CptControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
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

    @Test
    public void getCptReportById() throws Exception {
        String uri = "/cptreports/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void addCptReport() throws Exception {
        String uri = "/cptreports/add";
        CptReport cpt = new CptReport();
        cpt.setDueDate(new Date());
        cpt.setCptReport("Working......");

        String inputJson = super.mapToJson(cpt);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    @Test
    public void updateCptReport() throws Exception {
        String uri = "/cptreports/update";
        CptReport cpt = new CptReport();
        cpt.setDueDate(new Date());
        cpt.setId(1L);
        String inputJson = super.mapToJson(cpt);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}