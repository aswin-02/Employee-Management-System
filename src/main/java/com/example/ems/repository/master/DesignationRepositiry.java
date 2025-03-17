package com.example.ems.repository.master;

import com.example.ems.model.master.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepositiry extends JpaRepository<Designation, Long> {
}
