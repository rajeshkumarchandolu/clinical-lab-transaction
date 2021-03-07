package com.ckrprojects.clinicallabtransactions.service;

import com.ckrprojects.clinicallabtransactions.dao.ReportRepository;
import com.ckrprojects.clinicallabtransactions.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private static Map<String, String> REPORT_FIELDS_NATIVE_MAP =
            Map.of("phoneNumber", "phone_number", "doctorName",
                    "doctor_name");

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
