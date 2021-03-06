package com.ckrprojects.clinicallabtransactions.dao;

import com.ckrprojects.clinicallabtransactions.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
