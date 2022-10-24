package org.spbstu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "seizures", name = "seizure")
public class SeizureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "description")
    private String description;

    @Column(name = "seizure_date")
    private LocalDate seizureDate;
}
