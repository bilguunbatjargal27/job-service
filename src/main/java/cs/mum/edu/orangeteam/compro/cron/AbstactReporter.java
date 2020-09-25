package cs.mum.edu.orangeteam.compro.cron;

import cs.mum.edu.orangeteam.compro.DTO.Student;
import cs.mum.edu.orangeteam.compro.model.Job;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

public abstract class AbstactReporter {
    void reporter(Date date1, Date date2, RestTemplate restTemplate, Job job) {
        if(date1.compareTo(date2) == 0 || date1.compareTo(date2) < 0){ // will check due date before 2 weeks
            ResponseEntity<List<Student>> responseEntity = restTemplate.exchange("course-service/course/students/byjob/" + job.getId(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
                    });
            List<Student> students = responseEntity.getBody();
            for (Student student : students){

                ResponseEntity<String> responseEntity1 = restTemplate.exchange("course-service/course/students/noticeCpt/" + student.getId(), HttpMethod.GET, null, String.class);
                String msg = responseEntity1.getBody();
                System.out.println(msg);
            }
        }
    }
}
