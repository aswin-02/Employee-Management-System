package com.example.ems.service;

import com.example.ems.model.Leave;
import com.example.ems.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leave> getAllLeaves(){
        return leaveRepository.findAll();
    }

    public Optional<Leave> getLeaveById(Long id){
        return leaveRepository.findById(id);
    }

    public Leave createLeave(Leave leave){
        return leaveRepository.save(leave);
    }

    public Leave updateLeave(Long id, Leave updatedLeave){
        return leaveRepository.findById(id)
            .map(leave->{
                leave.setUserId(updatedLeave.getUserId());
                leave.setStartDate(updatedLeave.getStartDate());
                leave.setEndDate(updatedLeave.getEndDate());
                leave.setDuration(updatedLeave.getDuration());
                leave.setLeaveType(updatedLeave.getLeaveType());
                leave.setNumberOfDays(updatedLeave.getNumberOfDays());
                leave.setReason(updatedLeave.getReason());
                leave.setStatus(updatedLeave.getStatus());
                leave.setRejectReason(updatedLeave.getRejectReason());
                leave.setClCount(updatedLeave.getClCount());
                leave.setSlCount(updatedLeave.getSlCount());
                leave.setSlCount(updatedLeave.getSlCount());
                leave.setLossOfPayCount(updatedLeave.getLossOfPayCount());
                leave.setActive(updatedLeave.getActive());
                return leaveRepository.save(leave);
            }).orElseThrow(()->new RuntimeException("Leave not found with id: "+id));
    }

    public boolean deleteLeave(Long id) {
        try {
            if (!leaveRepository.existsById(id)) {
                return false;
            }
            leaveRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}