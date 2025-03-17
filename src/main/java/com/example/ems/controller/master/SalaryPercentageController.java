package com.example.ems.controller.master;

import com.example.ems.model.master.SalaryPercentage;
import com.example.ems.service.master.SalaryPercentageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master/salary-percentage")
@CrossOrigin("*")
public class SalaryPercentageController {
    @Autowired
    private SalaryPercentageService salaryPercentageService;

    @GetMapping
    public List<SalaryPercentage> getDefaultPercentage(){
        return salaryPercentageService.getDefaultPercentage();
    }

    @PostMapping
    public SalaryPercentage saveSalaryPercentage(@RequestBody SalaryPercentage salaryPercentage){
        return salaryPercentageService.saveSalaryPercentage(salaryPercentage);
    }

    @DeleteMapping
    public void deleteSalaryPercentage(){
        salaryPercentageService.deleteSalaryPercentage();
    }
}
