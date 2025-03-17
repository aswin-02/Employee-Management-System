package com.example.ems.service.master;

import com.example.ems.model.master.Bank;
import com.example.ems.repository.master.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<Bank> getAllBanks(){
        return bankRepository.findAll();
    }

    public Optional<Bank> getBankById(Long id){
        return bankRepository.findById(id);
    }

    public Bank createShift(Bank bank){
        return bankRepository.save(bank);
    }

    public Bank updateBank(Long id, Bank updatedBank){
        return bankRepository.findById(id)
            .map(bank -> {
                bank.setName(updatedBank.getName());
                bank.setActive(updatedBank.getActive());
                return bankRepository.save(bank);
            })
            .orElseThrow(()->new RuntimeException("Bank not found with id: "+id));
    }

    public void deleteBank(Long id){
        bankRepository.deleteById(id);
    }
}
