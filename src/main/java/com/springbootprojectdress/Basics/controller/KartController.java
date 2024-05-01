package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.Kart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basics-kart")
public class KartController {

    @PostMapping('/getAllProducts')
    private ResponseEntity<?>getAllProducts(){
        List<Kart>allProducts = 
    }
}
