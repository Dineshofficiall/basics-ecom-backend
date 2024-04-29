package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Roles;
import com.springbootprojectdress.Basics.repositiory.RoleRepository;
import com.springbootprojectdress.Basics.serviceInterface.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleImplementation implements RoleInterface {

    @Autowired
    RoleRepository roleRepository;

    //  createRoles
    public String createRoles(Roles roles) {
        roleRepository.save(roles);
        return "Role Created SuccessFully";
    }

    //  allRoles
    public List<Roles> allRoles() {
        return roleRepository.findAll();
    }

    //  fetchRoleName
    public List<Roles> fetchRoles(Long userRoleId) {
        return roleRepository.findByRoleName(userRoleId);
    }
}
