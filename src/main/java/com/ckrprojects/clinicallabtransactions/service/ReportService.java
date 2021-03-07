package com.ckrprojects.clinicallabtransactions.service;

import com.ckrprojects.clinicallabtransactions.dao.ReportRepository;
import com.ckrprojects.clinicallabtransactions.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public Report getEntityByid(String id) {
        final Optional<Report> visitOptional = reportRepository.findById(id);
        if (visitOptional.isPresent()) {
            return visitOptional.get();
        }
        throw new NoSuchElementException(id);
    }

    public Report update(Report report) {
        return reportRepository.save(report);
    }

    public void delete(String id) {
        Report report = getEntityByid(id);
    }

    public List<Report> search(Report report) {
        final ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("phoneNumber", matcher -> matcher.contains())
                .withMatcher("doctorName", matcher -> matcher.contains())
                .withIgnorePaths("id");
        return reportRepository.findAll(Example.of(report,
                exampleMatcher));
    }


    public List<Report> getAll() {
        return reportRepository.findAll(Sort.by(Sort.Direction.DESC, "lastModifiedDate"));
    }

}
