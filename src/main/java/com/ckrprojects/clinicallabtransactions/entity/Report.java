package com.ckrprojects.clinicallabtransactions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "report")
public class Report extends AuditingEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "visit_id", referencedColumnName = "id")
    private Visit visit;

    private Date reportDate;
    private String doctorName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private List<AdditionalFieldValue> additionalFieldValues;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private List<Fieldvalue> fieldvalues;
}
