package com.ckrprojects.clinicallabtransactions.dao;

import com.ckrprojects.clinicallabtransactions.entity.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {
}
