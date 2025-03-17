package com.example.ems.service.master;

import com.example.ems.model.master.SalaryPercentage;
import com.example.ems.repository.master.SalaryPercentageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryPercentageService {
    @Autowired
    private SalaryPercentageRepository salaryPercentageRepository;

    public List<SalaryPercentage> getDefaultPercentage(){
        return salaryPercentageRepository.findAll();
    }

    public SalaryPercentage saveSalaryPercentage(SalaryPercentage salaryPercentage){
        salaryPercentageRepository.deleteAll();
        return salaryPercentageRepository.save(salaryPercentage);
    }

    public void deleteSalaryPercentage(){
        salaryPercentageRepository.deleteAll();
    }

}
