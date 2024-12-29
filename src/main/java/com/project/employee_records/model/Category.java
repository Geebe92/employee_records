package com.project.employee_records.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Entity
@NoArgsConstructor(force = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCat;
    @NonNull
    private String name;
    @NonNull
    private String desc;
}
