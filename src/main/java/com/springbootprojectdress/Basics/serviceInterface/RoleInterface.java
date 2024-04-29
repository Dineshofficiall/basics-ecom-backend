package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Roles;

import java.util.List;

public interface RoleInterface {

    //  1.Role Created
    String createRoles(Roles roles);

    //  2.Get All Roles
    List<Roles> allRoles ();

    //  3.fetch role
    List<Roles> fetchRoles(Long userRoleId);
}
