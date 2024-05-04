package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    public List<ProductSize> findByProductId(Long pId);

//    void deleteByProductId(Long pId);
}
