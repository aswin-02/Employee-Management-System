package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){
        return employeeRepository.findById(id)
            .map(employee -> {
                employee.setName(updatedEmployee.getName());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setDesignation(updatedEmployee.getDesignation());
                employee.setDeleted(updatedEmployee.getDeleted());
                return employeeRepository.save(employee);
            })
            .orElseThrow(()-> new RuntimeException("Employee not found with id: "+id));
    }

    public void deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(()->new RuntimeException("Employee not found"));

        employee.setDeleted(true);
        employeeRepository.save(employee);
    }
}
