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

    List<Products> findByProductColor(String color);

    List<Products> findByProductPriceBetween(int startRange, int endRange);

    List<Products> findByProductDiscountGreaterThanEqualOrderByProductDiscount(Integer value);

    List<Products> findAllByOrderByProductPriceDesc();

    List<Products> findAllByOrderByProductPriceAsc();

    @Query("SELECT p FROM Products p WHERE ((p.productPrice * (100 - p.productDiscount) / 100) BETWEEN (p.productPrice * 0.3) AND (p.productPrice * 0.8))")
    List<Products> findProductsWithDiscountInRange();

}
