package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.ProductSize;

import java.util.List;

public interface ProductSizeInterface {

    String createProductSize(ProductSize productSize);

    List<ProductSize> getProductSizeId(Long pId);

    String productSizeDelById(Long pId);

    ProductSize productSizeUpdateById(Long pId, ProductSize productSize);
}
