package com.example.ems.service.master;

import com.example.ems.model.master.Designation;
import com.example.ems.repository.master.DesignationRepositiry;
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

    public Designation deleteDesignation(Long id){
        return designationRepositiry.findById(id)
                .map(designation -> {
                    designation.setDeleted(true);
                    return designationRepositiry.save(designation);
                })
                .orElseThrow(() -> new RuntimeException("Designation not found with id: " + id));
    }

    public Designation restoreDesignation(Long id) {
        Designation designation = designationRepositiry.findById(id)
                .orElseThrow(() -> new RuntimeException("Designation not found"));

        designation.setDeleted(false);
        return designationRepositiry.save(designation);
    }

}
