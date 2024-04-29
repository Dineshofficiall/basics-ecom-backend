package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.Roles;
import com.springbootprojectdress.Basics.serviceInterface.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Basics-Role")
public class RoleController {

    @Autowired
    RoleInterface roleInterface;

//  RoleCreated
    @PostMapping("/CreateRole")
    public ResponseEntity<?> createRole(@RequestBody Roles roles){
        String createRoleResponse = roleInterface.createRoles(roles);

        if (createRoleResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(createRoleResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred BackEnd");
        }
    }

//  GetAllRole
    @GetMapping("/getAllRole")
    public ResponseEntity<?> allRoles(){
        List<Roles> listRolesResponse = roleInterface.allRoles();

        if (listRolesResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(listRolesResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred BackEnd");
        }
    }

//  fetchRole
    @GetMapping("/User-Role-Fetch/{userRoleID}")
    public ResponseEntity<?> fetchRole(@PathVariable Long userRoleID){
        List<Roles> fetchResponse = roleInterface.fetchRoles(userRoleID);

        if (fetchResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(fetchResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred Backend");
        }
    }

}
