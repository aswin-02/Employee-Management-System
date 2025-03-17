package com.example.ems.service.master;

import com.example.ems.model.master.Shift;
import com.example.ems.repository.master.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> getAllShifts(){
        return shiftRepository.findAll();
    }

    public Optional<Shift> getShiftsById(Long id){
        return shiftRepository.findById(id);
    }

    public Shift createShift(Shift shift){
        return shiftRepository.save(shift);
    }

    public Shift updateShift(Long id, Shift updatedShift){
        return shiftRepository.findById(id)
            .map(shift -> {
                shift.setName(updatedShift.getName());
                shift.setActive(updatedShift.getActive());
                shift.setStart_time(updatedShift.getStart_time());
                shift.setEnd_time(updatedShift.getEnd_time());
                shift.setDeleted(updatedShift.getDeleted());
                return shiftRepository.save(shift);
            })
            .orElseThrow(()->new RuntimeException("Shift not found with id: "+id));
    }

    public void deleteShift(Long id){
        shiftRepository.deleteById(id);
    }
}
