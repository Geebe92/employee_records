package com.project.employee_records.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Entity
@NoArgsConstructor(force = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idUser;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    @JsonIgnoreProperties
    private String password;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String address;
    @NonNull
    private String zipcode;
    @NonNull
    private String city;
    @NonNull
    private Role role;
}
