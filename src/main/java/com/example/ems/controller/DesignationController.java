package com.example.ems.controller;

import com.example.ems.model.Designation;
import com.example.ems.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/designations")
@CrossOrigin("*")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @GetMapping
    public List<Designation> getAllDesignation(){
        return designationService.getAllDesignation();
    }

    @GetMapping("/id")
    public Optional<Designation> getDesignationById(@PathVariable Long id){
        return designationService.getDesignationById(id);
    }

    @PostMapping
    public Designation saveDesignation(@RequestBody Designation designation){
        return designationService.saveDesignation(designation);
    }

    @PutMapping("/{id}")
    public Designation updateDesignation(@PathVariable Long id, @RequestBody Designation designation){
        return designationService.updateDesignation(id, designation);
    }

    @DeleteMapping("/{id}")
    public void deleteDesignation(@PathVariable Long id){
        designationService.deleteDesignation(id);
    }
}
