package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Kart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface KartRepository extends JpaRepository<Kart, Long> {
    List<Kart> findByUserId(Long pId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Kart k WHERE k.productId = :productId")
    void deleteByProductId(Long productId);
}
