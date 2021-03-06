package com.ckrprojects.clinicallabtransactions.service;

import com.ckrprojects.clinicallabtransactions.dao.ReportRepository;
import com.ckrprojects.clinicallabtransactions.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public Report getEntityByid(Integer id) {
        final Optional<Report> visitOptional = reportRepository.findById(id);
        if (visitOptional.isPresent()) {
            return visitOptional.get();
        }
        throw new NoSuchElementException(Integer.toString(id));
    }

    public Report update(Report report) {
        return reportRepository.save(report);
    }

    public void delete(int id) {
        Report report = getEntityByid(id);
    }


}
