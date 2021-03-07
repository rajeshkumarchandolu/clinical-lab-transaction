package com.ckrprojects.clinicallabtransactions.controller;

import com.ckrprojects.clinicallabtransactions.entity.Report;
import com.ckrprojects.clinicallabtransactions.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;


    @GetMapping("/search")
    public List<Report> search(@RequestParam(required = false) String phoneNumber,
                               @RequestParam(required = false) String doctorName) {
        Report report = new Report();
        report.setPhoneNumber(phoneNumber);
        report.setDoctorName(doctorName);
        return reportService.search(report);
    }


    @GetMapping("/{id}")
    public Report get(@PathVariable("id") String id) {
        return reportService.getEntityByid(id);
    }

    @PostMapping("")
    public Report post(@RequestBody(required = true) Report report) {
        return reportService.save(report);
    }


    @PostMapping("/{id}")
    public Report put(@PathVariable("id") String id,
                      @RequestBody(required = true) Report report) {
        report.setId(id);
        return reportService.update(report);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id", required = true) String id) {
        reportService.delete(id);
    }

}
