package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.CptReport;

import java.util.Collection;

public interface CptReportService {
    public CptReport addCptReport(CptReport cptReport);
    public CptReport updateCptReport(CptReport cptReport);
    public void deleteCptReport(Long id);
    public CptReport findCptReportById(Long id);
    public Collection<CptReport> findAll();
}
