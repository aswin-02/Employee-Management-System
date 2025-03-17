package com.example.ems.controller.master;

import com.example.ems.model.master.Shift;
import com.example.ems.service.master.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/shifts")
@CrossOrigin("*")
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @GetMapping
    public List<Shift> getAllShifts(){
        return shiftService.getAllShifts();
    }

    @GetMapping("{id}")
    public Optional<Shift> getShiftById(@PathVariable Long id){
        return shiftService.getShiftsById(id);
    }

    @PostMapping
    public Shift createShift(@RequestBody Shift shift){
        return shiftService.createShift(shift);
    }

    @PutMapping("/{id}")
    public Shift updateShift(@PathVariable Long id, @RequestBody Shift shift){
        return shiftService.updateShift(id, shift);
    }

    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable Long id){
        shiftService.deleteShift(id);
    }
}
