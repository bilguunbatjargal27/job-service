package cs.mum.edu.orangeteam.compro.cron;

import cs.mum.edu.orangeteam.compro.DTO.Student;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.model.JobSearchReport;
import cs.mum.edu.orangeteam.compro.service.CptReportService;
import cs.mum.edu.orangeteam.compro.service.JobSearchService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class JobSearchReportReminder extends AbstactReporter{

    @Autowired
    JobSearchService jobSearchService;

    @Autowired
    RestTemplate restTemplate;

    @Scheduled(cron =  "0 0 */6 ? * *") // every 6 hours this cron works
    public void cptReportReminder(){
        List<JobSearchReport> jobSearchReports = jobSearchService.getAllJobSearchReport();
        Date date = DateUtils.addDays(new Date(), 21);
        for(JobSearchReport report : jobSearchReports){
            reporter(date, report.getDueDate(), restTemplate, report.getJob());
        }
        System.out.println("REMIND JOB SEARCH REPORT");
    }

}
