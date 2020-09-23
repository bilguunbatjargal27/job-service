package cs.mum.edu.orangeteam.compro.cron;

import cs.mum.edu.orangeteam.compro.DTO.Student;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.service.CptReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@EnableScheduling
public class CPTReportReminder {

    @Autowired
    CptReportService cptReportService;

    @Autowired
    RestTemplate restTemplate;

    // CPT duedate 2 weeks before

    @Scheduled(cron =  "0 0 */6 ? * *") // every 6 hours this cron works
    public void cptReportReminder(){
        List<CptReport> cptReportList = (List<CptReport>) cptReportService.findAll();
        for(CptReport report : cptReportList){
            if(1 == 1){ // will check due date before 2 weeks
                Job job = report.getJob();
                ResponseEntity<List<Student>> responseEntity = restTemplate.exchange("http://course-service/course/students/byjob/" + job.getId(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
                        });
                List<Student> students = responseEntity.getBody();
                for (Student student : students){

                    ResponseEntity<String> responseEntity1 = restTemplate.exchange("http://course-service/course/students/noticeCpt/" + student.getId(), HttpMethod.GET, null, String.class);
                    String msg = responseEntity1.getBody();
                    System.out.println(msg);
                }
            }
        }
        System.out.println("REMIND CPT REPORT");
    }

}
