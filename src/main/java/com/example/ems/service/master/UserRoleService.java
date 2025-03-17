package com.example.ems.service.master;

import com.example.ems.model.master.UserRole;
import com.example.ems.repository.master.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    public UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles(){
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> getUserRoleById(Long id){
        return userRoleRepository.findById(id);
    }

    public UserRole saveUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    public UserRole updateUserRole(Long id, UserRole updatedUserRole){
        return userRoleRepository.findById(id)
            .map(userRole -> {
                userRole.setName(updatedUserRole.getName());
                userRole.setActive(updatedUserRole.getActive());
                return userRoleRepository.save(userRole);
            })
            .orElseThrow(()->new RuntimeException("UserRole not found with id: "+id));
    }

    public void deleteUserRole(Long id){
        userRoleRepository.deleteById(id);
    }
}
