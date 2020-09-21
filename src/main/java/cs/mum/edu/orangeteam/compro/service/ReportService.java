package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Report;

import java.util.Collection;

public interface ReportService {
    public Report addReport(Report report);
    public Report updateReport(Report report);
    public void deleteReport(Long id);
    public Report findReportById(Long id);
    public Collection<Report> findAll();

}
