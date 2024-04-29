package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    @Query(value = "SELECT * FROM ROLE where ID in(SELECT ID FROM USERS_ROLES WHERE ID=?1)", nativeQuery = true)
    List<Roles> findByRoleName(Long userId);
}
