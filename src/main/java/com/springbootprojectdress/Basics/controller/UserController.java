package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.Users;
import com.springbootprojectdress.Basics.serviceInterface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Basics-Users")
public class UserController {
    @Autowired
    UserInterface userInterface;


    //  Register - create [admin-user]
    @PostMapping("/CreateUser/{roleId}")
    public ResponseEntity<?> createUser(@RequestBody Users users, @PathVariable Long roleId){
        String createUserResponse = userInterface.createUser(users, roleId);

        if (users != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(createUserResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred BackEnd");
        }
    }

    //  LoginUser
    @PostMapping("/User")
    public ResponseEntity<?> singleUser(@RequestBody Users users){
        Users retrieveUserResponse = userInterface.retrieveUser(users);

        if (retrieveUserResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(retrieveUserResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred BackEnd");
        }
    }

//  update by userId
    @PutMapping("/User-Update/{userId}")
    public ResponseEntity<?> userUpdate (@RequestBody Users usersUpdate, @PathVariable Long userId){
        Users userUpdateResponse = userInterface.updateUser(usersUpdate, userId);

        if (userUpdateResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userUpdateResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred BackEnd");
        }
    }

    //  SingleUser Delete
    @DeleteMapping("/delete-User/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        String deleteUserResponse = userInterface.deleteUser(userId);

        if (deleteUserResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(deleteUserResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred BackEnd");
        }
    }

//  admin

//  allUsers
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> allUsers(){
        List<Users> adminResponse = userInterface.allUsers();

        if (adminResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(adminResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred");
        }
    }

}
