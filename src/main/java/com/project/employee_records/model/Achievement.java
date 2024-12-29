package com.project.employee_records.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor(force = true)
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAchiev;
    @NonNull
    private String achievName;
    @NonNull
    private String achievDesc;
    @NonNull
    private Integer achievValueScore;
    @NonNull
    @CreationTimestamp
    private LocalDateTime achievStartDate;
    @NonNull
    private LocalDate achievEndDate;
}
