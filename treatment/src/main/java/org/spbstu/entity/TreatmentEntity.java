package org.spbstu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "treatments", name = "treatment")
public class TreatmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "description")
    private String description;

    @Column(name = "treatment_date")
    private Date treatmentDate;
}
