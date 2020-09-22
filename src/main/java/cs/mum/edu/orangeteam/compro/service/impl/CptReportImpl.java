package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.DAO.CptReportRepository;
import cs.mum.edu.orangeteam.compro.model.CptReport;
import cs.mum.edu.orangeteam.compro.model.Job;
import cs.mum.edu.orangeteam.compro.service.CptReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
@Transactional
public class CptReportImpl implements CptReportService {

   @Autowired
   private CptReportRepository cpt;

   @Override
    public CptReport addCptReport(CptReport cptReport) {
        return cpt.save(cptReport);
    }

    @Override
    public CptReport updateCptReport(CptReport cptReport) {
        return cpt.save(cptReport);
    }

    @Override
    public void deleteCptReport(Long id) {
         cpt.deleteById(id);
    }

    @Override
    public CptReport findCptReportById(Long id) {
        if(cpt.findById(id).isPresent())
            return cpt.findById(id).get();
        else
            return null;
    }

    @Override
    public Collection<CptReport> findAll() {
        return cpt.findAll();
    }



}
