package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Products;

import java.util.List;

public interface ProductInterface {
//  1.addProduct
    String addSingleProduct(Products products);

//  2.retrieve allProduct
    List<Products> getAllProduct();

//  3.retrieve singleProduct
    Products getSingleProduct(Long id);

//  4.updateProduct
    Products updateSingleProduct(Products products, Long id);

//  5.deleteProduct
    String deleteSingleProduct(Long id);

//  6.CategoryWise
    List<Products> searchProductByName(String searchName);

//  7.
    List<Products> getProductByCategory(String categoryName);

    List<Products> getProductByRating(int filterRating);
}
