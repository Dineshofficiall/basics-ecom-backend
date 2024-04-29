package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Products;
import com.springbootprojectdress.Basics.repositiory.ProductRepository;
import com.springbootprojectdress.Basics.repositiory.RatingRepository;
import com.springbootprojectdress.Basics.serviceInterface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImplementation implements ProductInterface {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RatingRepository ratingRepository;

//  add product
    public String addSingleProduct(Products products) {
//        if (products.getId() != null){
//            productRepository.save(products);
//        }
        products.setProductDiscount(0);
        productRepository.save(products);
//        else {
//            return "Failed to add product: Product with ID " + products.getId() + " already exists.";
//        }
        return "Saved SuccessFully";
    }

//  get all product
    public List<Products> getAllProduct() {
        return productRepository.findAll();
    }


//  singleProduct id by product
    public Products getSingleProduct(Long id) {
        return productRepository.findById(id).get();
    }


//  update id by product
    public Products updateSingleProduct(Products products, Long id) {
         Products existing = productRepository.findById(id).get();

         existing.setProductImage((products.getProductImage()));
         existing.setProductDescription(products.getProductDescription());
         existing.setProductPrice(products.getProductPrice());
         existing.setCategories(products.getCategories());
//         existing.setStocksUnit(products.getStocksUnit());
         existing.setProductName(products.getProductName());

         productRepository.save(existing);
         return existing;
    }


//  delete id by product
    public String deleteSingleProduct(Long id) {
        productRepository.deleteById(id);
        return "successFully deleted";
    }

//  categoryWise
    public List<Products> searchProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

//
    public List<Products> getProductByCategory(String categoryName) {
        return productRepository.findByCategories(categoryName);
    }


    public List<Products> getProductByRating(int filterRating) {
        List<Long> productIds = ratingRepository.findProductsByRating(filterRating);
        return productRepository.findByIdIn(productIds);
    }


}
