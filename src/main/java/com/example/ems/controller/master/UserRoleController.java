package com.example.ems.controller.master;

import com.example.ems.model.master.UserRole;
import com.example.ems.service.master.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/user-roles")
@CrossOrigin("*")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllUserRoles(){
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public Optional<UserRole> getUserRoleById(@PathVariable Long id){
        return userRoleService.getUserRoleById(id);
    }

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole){
        return userRoleService.saveUserRole(userRole);
    }

    @PutMapping("/{id}")
    public UserRole updateUserRole(@PathVariable Long id, @RequestBody UserRole userRole){
        return userRoleService.updateUserRole(id, userRole);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id){
        userRoleService.deleteUserRole(id);
    }
}
