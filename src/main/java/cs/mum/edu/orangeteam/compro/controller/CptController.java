package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.service.CptReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cptreports")
public class CptController {

    @Autowired
    private CptReportService cptReportService;

    @GetMapping("")
    public ResponseEntity<?> getAllCptReport() {
        List<CptReport> cptReports = (List<CptReport>) cptReportService.findAll();
        return ResponseEntity.ok(cptReports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCptReportById(@PathVariable("id") Long id) {
        CptReport cptReport = cptReportService.findCptReportById(id);
        return ResponseEntity.ok(cptReport);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCptReport(@Valid @RequestBody final CptReport cptReport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        CptReport cptReport1 = cptReportService.addCptReport(cptReport);
        return ResponseEntity.status(HttpStatus.OK).body(cptReport1);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCptReport(@Valid @RequestBody final CptReport cptReport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        CptReport cptReport1 = cptReportService.updateCptReport(cptReport);
        return ResponseEntity.status(HttpStatus.OK).body(cptReport1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCptReport(@PathVariable("id") Long id) {
        CptReport cptReport = cptReportService.findCptReportById(id);
        if (cptReport == null) return ResponseEntity.badRequest().body("There is no cpt has an id equal to" + id);
        cptReportService.findCptReportById(id);
        return ResponseEntity.status(HttpStatus.OK).body("cpt is deleted successfully");
    }

}
