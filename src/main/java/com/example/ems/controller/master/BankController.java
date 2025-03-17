package com.example.ems.controller.master;

import com.example.ems.model.master.Bank;
import com.example.ems.service.master.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/banks")
@CrossOrigin("*")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> getAllBanks(){
        return bankService.getAllBanks();
    }

    @GetMapping("{id}")
    public Optional<Bank> getBankById(@PathVariable Long id){
        return bankService.getBankById(id);
    }

    @PostMapping
    public Bank createBank(@RequestBody Bank bank){
        return bankService.createShift(bank);
    }

    @PutMapping("{id}")
    public Bank updateBank(@PathVariable Long id, @RequestBody Bank bank){
        return bankService.updateBank(id, bank);
    }

    @DeleteMapping("{id}")
    public void deleteBank(@PathVariable Long id){
        bankService.deleteBank(id);
    }
}
