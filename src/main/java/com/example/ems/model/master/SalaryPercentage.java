package com.example.ems.model.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="salary_percentage")
public class SalaryPercentage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public Double basicPercentage;

    public Double hraPercentage;

    public Double esiPercentage;

    public Double pfPercentage;

    public Double companyEsiPercentage;

    public Double companyPfPercentage;
}
