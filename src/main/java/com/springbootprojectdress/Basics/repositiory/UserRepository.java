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

    @Query(value = "SELECT id,user_name, user_mail FROM users WHERE id = :userId", nativeQuery = true)
    List<Object[]> findByUser(@Param("userId") Long userId);

}
