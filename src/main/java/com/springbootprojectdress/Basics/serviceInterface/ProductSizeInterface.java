package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeInterface extends JpaRepository<ProductSize, Long> {
}
