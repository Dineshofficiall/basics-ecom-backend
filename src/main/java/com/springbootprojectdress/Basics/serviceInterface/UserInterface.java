package com.springbootprojectdress.Basics.serviceInterface;


import com.springbootprojectdress.Basics.entity.Users;

import java.util.List;

public interface UserInterface {

//  1.User Created
    String createUser(Users users, Long roleId);

//  2.login retrieve User
    Users retrieveUser(Users users);

//  3.allUser[admin-user]
    List<Users> allUsers();

//  6.update user
    Users updateUser(Users userUpdate, Long userId);

//  7.delete user
    String deleteUser(Long userId);
}
