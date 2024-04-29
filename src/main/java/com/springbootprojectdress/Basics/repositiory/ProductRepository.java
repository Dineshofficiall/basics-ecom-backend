package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByCategories(String categoryName);

    List<Products> findByProductName(String productName);

    List<Products> findByIdIn(List<Long> productIds);
}
