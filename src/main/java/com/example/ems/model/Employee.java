package com.example.ems.model;

import com.example.ems.model.master.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @Column(nullable = false)
    private String employeeId;

    @ManyToOne
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;

    @DateTimeFormat
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private String gender;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    @ManyToMany
    @JoinTable(
        name = "employee_client",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients;

    private String phoneNumber;

    private String aadharNumber;

    private String esiNumber;

    private String uanNumber;

    @DateTimeFormat
    private LocalDate dateOfJoining;

    @DateTimeFormat
    private LocalDate dateOfLeaving;

    private int casualLeave;

    private int sickLeave;

    private int privilegeLeave;

    private double salary;

    private double gross;

    private double basic;

    private double hra;

    private double esi;

    private double pf;

    private double insurance;

    private double netAmount;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    private String accountNumber;

    private String ifsc;

    private String email;

    private String password;

    private String rememberToken;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Boolean deleted;
}
