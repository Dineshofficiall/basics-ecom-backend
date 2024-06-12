package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.KartQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartQuantityRepository extends JpaRepository<KartQuantity, Long> {
    KartQuantity findByUserIdAndProductSizeId(Long userId, Long productSizeId);

    void deleteByUserIdAndProductSizeId(Long userId, Long productSizeId);
}
