package com.example.ems.repository;

import com.example.ems.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepositiry extends JpaRepository<Designation, Long> {
}
