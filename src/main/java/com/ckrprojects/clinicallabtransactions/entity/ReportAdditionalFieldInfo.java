package com.ckrprojects.clinicallabtransactions.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "report_addiitional_field_info")
public class ReportAdditionalFieldInfo extends AuditingEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String defaultValue;
}

