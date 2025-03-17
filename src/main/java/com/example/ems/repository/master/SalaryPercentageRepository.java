package com.example.ems.repository.master;

import com.example.ems.model.master.SalaryPercentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryPercentageRepository extends JpaRepository<SalaryPercentage, Long> {
}
