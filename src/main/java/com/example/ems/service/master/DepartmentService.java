package com.example.ems.service.master;

import com.example.ems.model.master.Department;
import com.example.ems.repository.master.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        return departmentRepository.findById(id)
            .map(department -> {
                department.setName(updatedDepartment.getName());
                department.setActive(updatedDepartment.getActive());
                department.setDeleted(updatedDepartment.getDeleted());
                return departmentRepository.save(department);
            })
            .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}
