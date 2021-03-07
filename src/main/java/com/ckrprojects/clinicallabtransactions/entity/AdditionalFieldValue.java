package com.ckrprojects.clinicallabtransactions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "report_additional_fields_value")
public class AdditionalFieldValue extends AuditingEntity<String> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "report_id", nullable = true,
            referencedColumnName = "id", insertable = false,
            updatable = false)
    private Report report;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_info")
    private ReportAdditionalFieldInfo reportAdditionalFieldInfo;

    private String value;
}
