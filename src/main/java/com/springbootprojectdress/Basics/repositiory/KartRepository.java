package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Kart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KartRepository extends JpaRepository<Kart, Long> {
    List<Kart> findByUserId(Long pId);
}
