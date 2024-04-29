package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Roles;
import com.springbootprojectdress.Basics.entity.Users;
import com.springbootprojectdress.Basics.repositiory.RoleRepository;
import com.springbootprojectdress.Basics.repositiory.UserRepository;
import com.springbootprojectdress.Basics.serviceInterface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserInterface {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


//  registerPage createUser
    public String createUser(Users users, Long roleId) {
        Roles role = roleRepository.findById(roleId).get();
        if (users.getRoleList() != null) {
            users.getRoleList().add(role);// Initialize roleList if null
        }

        userRepository.save(users);
        return "User Created SuccessFully";
    }

//  loginPage validation
    public Users retrieveUser(Users users) {
        Users existingUser = userRepository.findByMail(users.getMail());

        if (existingUser != null && existingUser.getMail().equals(users.getMail()) && existingUser.getPassword().equals(users.getPassword())){
            return existingUser;
        }
        else {
            return null;
        }
    }

//  AllUsers
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

//  userUpdate
    public Users updateUser(Users userUpdate, Long userId) {
        Users user = userRepository.findById(userId).get();

        if (userUpdate.getUserName() != null){
            user.setUserName(userUpdate.getUserName());
        }
        if (userUpdate.getMail() != null){
            user.setMail(userUpdate.getMail());
        }
        if (userUpdate.getPassword() != null){
            user.setPassword(userUpdate.getPassword());
        }
        if (userUpdate.getPhoneNumber() != null){
            user.setPhoneNumber(userUpdate.getPhoneNumber());
        }
        userRepository.save(user);

        return user;
    }

//  deleteUser
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "User Deleted SuccessFully";
    }
}
