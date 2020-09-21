package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Report;
import cs.mum.edu.orangeteam.compro.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("")
    public List<Report> getAllReport(){
        return (List<Report>) reportService.findAll();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable("id") Long id){
        return reportService.findReportById(id);
    }


    @PostMapping("/add")
    public Report addReport(@RequestBody final Report report){
        return reportService.addReport(report);
    }

    @PutMapping("/update")
    public Report updateReport(@RequestBody final Report report){
        return reportService.updateReport(report);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteReport(@PathVariable("id") Long id){
        reportService.deleteReport(id);
        return true;
    }
}
