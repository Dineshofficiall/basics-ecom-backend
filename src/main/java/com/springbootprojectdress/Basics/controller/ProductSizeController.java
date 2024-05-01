package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.ProductSize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Basics-Products-Size")
public class ProductSizeController {

//  create
    public ResponseEntity<?> createProductSize(@RequestBody ProductSize productSize){

    }
}
