package com.example.ems.service;

import com.example.ems.model.Designation;
import com.example.ems.repository.DesignationRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {
    @Autowired
    public DesignationRepositiry designationRepositiry;

    public List<Designation> getAllDesignation(){
        return designationRepositiry.findAll();
    }

    public Optional<Designation> getDesignationById(Long id){
        return designationRepositiry.findById(id);
    }

    public Designation saveDesignation(Designation designation){
        return designationRepositiry.save(designation);
    }

    public Designation updateDesignation(Long id, Designation updatedDesignation){
        return designationRepositiry.findById(id)
            .map(designation->{
                designation.setName(updatedDesignation.getName());
                designation.setManagement(updatedDesignation.getManagement());
                designation.setActive(updatedDesignation.getActive());
                designation.setDeleted(updatedDesignation.getDeleted());
                return designationRepositiry.save(designation);
            })
            .orElseThrow(()->new RuntimeException("Designation not found with id: "+id));
    }

    public void deleteDesignation(Long id){
        Designation designation = designationRepositiry.findById(id)
                .orElseThrow(() -> new RuntimeException("Designation not found"));

        designation.setDeleted(true);
        designationRepositiry.save(designation);
    }
}
