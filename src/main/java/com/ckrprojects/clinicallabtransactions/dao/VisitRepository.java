package com.ckrprojects.clinicallabtransactions.dao;

import com.ckrprojects.clinicallabtransactions.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
