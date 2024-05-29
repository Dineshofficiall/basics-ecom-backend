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
        products.setProductDiscount(0);
        productRepository.save(products);
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

         if(products.getProductImage() != null){
             existing.setProductImage((products.getProductImage()));
         }
         if(products.getProductDescription() != null){
             existing.setProductDescription(products.getProductDescription());
         }
         if(products.getProductPrice() != null){
             existing.setProductPrice(products.getProductPrice());
         }
         if(products.getCategories() != null){
             existing.setCategories(products.getCategories());
         }
         if(products.getProductName() != null){
             existing.setProductName(products.getProductName());
         }
         
         productRepository.save(existing);
         return existing;
    }


//  delete id by product
    public String deleteSingleProduct(Long id) {
        productRepository.deleteById(id);
        return "successFully deleted";
    }

//  searchCategoryWise
    public List<Products> searchProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

//  getCategoryWise
    public List<Products> getProductByCategory(String categoryName) {
        return productRepository.findByCategories(categoryName);
    }

//  rating
    public List<Products> getProductByRating(int filterRating) {
        List<Long> productIds = ratingRepository.findProductsByRating(filterRating);
        return productRepository.findByIdIn(productIds);
    }

//  colorCategory
    public List<Products> getColorByProduct(String productColor) {
        return productRepository.findByProductColor(productColor);
    }

//  priceHighToLow
    public List<Products> getProductHighToLowPrice() {
        return productRepository.findAllByOrderByProductPriceDesc();
    }

//  priceLowToHigh
    public List<Products> getProductLowToHighPrice() {
        return productRepository.findAllByOrderByProductPriceAsc();
    }

//  priceRange
    public List<Products> getProductRange(int startPrice, int endPrice) {
        return productRepository.findByProductPriceBetween(startPrice, endPrice);
    }

}
