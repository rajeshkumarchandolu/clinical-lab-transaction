package com.ckrprojects.clinicallabtransactions.dao;

import com.ckrprojects.clinicallabtransactions.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, String> {
}
