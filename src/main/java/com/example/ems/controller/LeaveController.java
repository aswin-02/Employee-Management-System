package com.example.ems.controller;

import com.example.ems.model.Leave;
import com.example.ems.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin("*")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public List<Leave> getAllLeaves(){
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Optional<Leave> getLeaveById(@PathVariable Long id){
        return leaveService.getLeaveById(id);
    }

    @PostMapping
    public Leave createLeave(@RequestBody Leave leave){
        return leaveService.createLeave(leave);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id, @RequestBody Leave leave){
        return leaveService.updateLeave(id, leave);
    }

    @DeleteMapping("/{id}")
    public boolean deleteLeave(@PathVariable Long id){
        return leaveService.deleteLeave(id);
    }

}
