package com.ckrprojects.clinicallabtransactions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id", referencedColumnName = "id")
    private Visit visit;

    private String phoneNumber;
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
