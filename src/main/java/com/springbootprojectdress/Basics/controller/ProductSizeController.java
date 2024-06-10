package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.ProductSize;
import com.springbootprojectdress.Basics.serviceInterface.ProductSizeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Basics-Products-Size")
public class ProductSizeController {

//  Product Interface
    @Autowired
    ProductSizeInterface productSizeInterface;

//  create
    @PostMapping("/create")
    public ResponseEntity<?> createProductSize(@RequestBody ProductSize productSize){
        String productSizeResponse = productSizeInterface.createProductSize(productSize);

        if (productSize != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productSizeResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred Backend");
        }
    }

//  getAll productSize by id
    @GetMapping("/getProductSize/{pId}")
    public ResponseEntity<?> getProductSizeId(@PathVariable Long pId){
        List<ProductSize> productSizeGetResponse = productSizeInterface.getProductSizeId(pId);

        if (productSizeGetResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productSizeGetResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred Backend");
        }
    }

//  updateById
    @PutMapping("/update")
    public ResponseEntity<?> updateProductSizeById(@RequestBody ProductSize productSize){
        ProductSize productSizeDelResponse = productSizeInterface.productSizeUpdateById(productSize);

        if (productSizeDelResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productSizeDelResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred Backend");
        }
    }

//  delete productSize by id
    @DeleteMapping("/delete/{pId}")
    public ResponseEntity<?> deleteProductSizeById(@PathVariable Long pId){
        String productSizeDelResponse = productSizeInterface.productSizeDelById(pId);

        if (productSizeDelResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productSizeDelResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred Backend");
        }
    }
}
