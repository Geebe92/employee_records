package com.project.employee_records.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor(force = true)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTask;
    @NonNull
    private String taskName;
    @NonNull
    private String taskDescription;
    private Boolean taskStatus;
    @NonNull
    private String taskDifficulty;
    @NonNull
    @CreationTimestamp
    private LocalDateTime taskStartDate;
    @CreationTimestamp
    private LocalDateTime taskEndDate;
    @NonNull
    @Column(length = 2)
    private Integer taskScore;
}
