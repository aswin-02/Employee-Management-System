package com.example.ems.seeder;
import com.example.ems.model.Department;
import com.example.ems.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;

    public DataSeeder(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) {
//        if (departmentRepository.count() == 0) { // Avoid duplicate seeding
//            Department dept1 = new Department(1L,"HR", LocalDateTime.now(),null, true, false);
//            Department dept2 = new Department(2L,"IT",LocalDateTime.now(),null, true, false);
//            departmentRepository.saveAll(List.of(dept1, dept2));
//            System.out.println("Seeded initial department data!");
//        }
    }
}
