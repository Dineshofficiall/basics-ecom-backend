package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.ProductSize;
import com.springbootprojectdress.Basics.entity.Products;
import com.springbootprojectdress.Basics.repositiory.ProductSizeRepository;
import com.springbootprojectdress.Basics.serviceInterface.ProductSizeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizeImplementation implements ProductSizeInterface {

    @Autowired
    ProductSizeRepository productSizeRepository;

//  create
    public String createProductSize(ProductSize productSize) {
//        productSize.setSize(productSize.getSize().toUpperCase());
        productSizeRepository.save(productSize);
        return "Created Successfully";
    }

//  getAll Size
    public List<ProductSize> getProductSizeId(Long pId) {
        return productSizeRepository.findByProductId(pId);
    }

//  updateById
    public ProductSize productSizeUpdateById(ProductSize productSize) {
        ProductSize productSize1 = productSizeRepository.findById(productSize.getId()).get();

        productSize1.setSize(productSize.getSize());
        productSize1.setQuantity(productSize1.getQuantity());
        return productSizeRepository.save(productSize1);
    }

//  deleteById
    public String productSizeDelById(Long pId) {
        productSizeRepository.deleteById(pId);
        return "Deleted Successfully";
    }
}
