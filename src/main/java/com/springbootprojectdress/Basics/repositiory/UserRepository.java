package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Roles;
import com.springbootprojectdress.Basics.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT obj FROM Users obj WHERE obj.mail = :mail")
    Users findByMail(@Param("mail") String mail);

//    if only need all users in the table in not need admin then this is query
//    @Query(value = "select * from users where user_id in (select user_id from users_roles where role_id = 2)", nativeQuery = true)
//    List<Users> findAllAdminByRoleId();


//    if only need all admins in the table in not need user then this is query
//    @Query(value = "select * from users where user_id in (select user_id from users_roles where role_id = 1)", nativeQuery = true)
//    List<Users> findAllUsersByRoleId();

}
