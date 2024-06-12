package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.KartQuantity;
import com.springbootprojectdress.Basics.serviceInterface.KartQuantityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Basics-kart-quantity")
public class KartQuantityController {

    @Autowired
    KartQuantityInterface kartQuantityInterface;

//  create
    @PostMapping("/create")
    public ResponseEntity<?> createKartQuantity(@RequestBody KartQuantity kartQuantity){
        String kartData = kartQuantityInterface.createKartData(kartQuantity);

        if (kartData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(kartData);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error quantity Creation");
        }
    }

//  getSingleUserAllQuantity
    @GetMapping("/getQuantityById/{userId}/{productSizeId}")
    public ResponseEntity<?> getAllKartQuantity(@PathVariable Long userId, @PathVariable Long productSizeId){
        KartQuantity kartData = kartQuantityInterface.getAllQuantity(userId, productSizeId);

        if (kartData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(kartData);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error quantity Creation");
        }
    }


//  updateSingleUserQuantity
    @PutMapping("/updateQuantityById")
    public ResponseEntity<?> updateKartQuantity(@RequestBody KartQuantity kartQuantity){
        KartQuantity kartData = kartQuantityInterface.updateQuantity(kartQuantity);

        if (kartData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(kartData);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error quantity Creation");
        }
    }

//  deleteSingleUserQuantity
    @DeleteMapping("/deleteQuantityById/{userId}/{productSizeId}")
    public ResponseEntity<?> deleteKartQuantity(@PathVariable Long userId, @PathVariable Long productSizeId){
        String kartData = kartQuantityInterface.deleteQuantity(userId, productSizeId);

        if (kartData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(kartData);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error quantity Creation");
        }
    }
}
