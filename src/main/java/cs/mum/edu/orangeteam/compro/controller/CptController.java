package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.service.CptReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cptreports")
public class CptController {
    @Autowired
    private CptReportService cptReportService;


    @GetMapping("")
    public List<CptReport> getAllCptReport(){
        return (List<CptReport>) cptReportService.findAll();
    }

    @GetMapping("/{id}")
    public CptReport getCptReportById(@PathVariable("id") Long id){
        return cptReportService.findCptReportById(id);
    }


    @PostMapping("/add")
    public CptReport addCptReport(@RequestBody final CptReport cpt){

        return cptReportService.addCptReport(cpt);
    }

    @PutMapping("/update")
    public CptReport updateStudent(@RequestBody final CptReport cpt){
        return cptReportService.updateCptReport(cpt);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCptReport(@PathVariable("id") Long id){
        cptReportService.deleteCptReport(id);
        return true;
    }
}
