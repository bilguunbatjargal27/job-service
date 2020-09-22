package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.repository.ReportRepository;
import cs.mum.edu.orangeteam.compro.model.Report;
import cs.mum.edu.orangeteam.compro.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report updateReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);

    }

    @Override
    public Report findReportById(Long id) {
        if (reportRepository.findById(id).isPresent())
            return reportRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public Collection<Report> findAll() {
        return reportRepository.findAll();
    }
}
