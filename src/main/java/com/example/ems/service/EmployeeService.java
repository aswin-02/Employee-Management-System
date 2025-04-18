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
                employee.setDesignation(updatedEmployee.getDesignation());
                employee.setEmployeeId(updatedEmployee.getEmployeeId());
                employee.setShift(updatedEmployee.getShift());
                employee.setDob(updatedEmployee.getDob());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setGender(updatedEmployee.getGender());
                employee.setTeam(updatedEmployee.getTeam());
                employee.setClients(updatedEmployee.getClients());
                employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                employee.setAadharNumber(updatedEmployee.getAadharNumber());
                employee.setEsiNumber(updatedEmployee.getEsiNumber());
                employee.setUanNumber(updatedEmployee.getUanNumber());
                employee.setDateOfJoining(updatedEmployee.getDateOfJoining());
                employee.setDateOfLeaving(updatedEmployee.getDateOfLeaving());
                employee.setCasualLeave(updatedEmployee.getCasualLeave());
                employee.setSickLeave(updatedEmployee.getSickLeave());
                employee.setPrivilegeLeave(updatedEmployee.getPrivilegeLeave());
                employee.setSalary(updatedEmployee.getSalary());
                employee.setGross(updatedEmployee.getGross());
                employee.setBasic(updatedEmployee.getBasic());
                employee.setHra(updatedEmployee.getHra());
                employee.setEsi(updatedEmployee.getEsi());
                employee.setPf(updatedEmployee.getPf());
                employee.setInsurance(updatedEmployee.getInsurance());
                employee.setNetAmount(updatedEmployee.getNetAmount());
                employee.setBank(updatedEmployee.getBank());
                employee.setAccountNumber(updatedEmployee.getAccountNumber());
                employee.setIfsc(updatedEmployee.getIfsc());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setPassword(updatedEmployee.getPassword());
                employee.setRememberToken(updatedEmployee.getRememberToken());
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
