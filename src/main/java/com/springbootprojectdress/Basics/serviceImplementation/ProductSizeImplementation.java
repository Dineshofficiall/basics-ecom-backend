package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.ProductSize;
import com.springbootprojectdress.Basics.repositiory.ProductSizeRepository;
import com.springbootprojectdress.Basics.serviceInterface.ProductSizeInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductSizeImplementation implements ProductSizeInterface {

    @Autowired
    ProductSizeRepository productSizeRepository;

//  create
    public String createProductSize(ProductSize productSize) {
        productSize.setSize(productSize.getSize().toUpperCase());
        productSizeRepository.save(productSize);
        return "Created Successfully";
    }

//  getAll Size
    public List<ProductSize> getProductSizeId(Long pId) {
        return productSizeRepository.findByProductId(pId);
    }


//    public String productSizeDelById(Long pId) {
//        productSizeRepository.deleteByProductId(pId);
//        return "Deleted Successfully";
//    }


}
