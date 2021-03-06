package com.ckrprojects.clinicallabtransactions.dao;

import com.ckrprojects.clinicallabtransactions.entity.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Integer> {
}
