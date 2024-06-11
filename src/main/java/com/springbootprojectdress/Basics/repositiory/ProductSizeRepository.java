package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    public List<ProductSize> findByProductId(Long pId);

//    @Query(value = "SELECT * FROM product_size WHERE ", nativeQuery = true)
//    public ProductSize findBySize(String size);
//    void deleteByProductId(Long pId);

}
