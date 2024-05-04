package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.Kart;
import com.springbootprojectdress.Basics.serviceInterface.KartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basics-kart")
public class KartController {

    @Autowired
    KartInterface kartInterface;

    @PostMapping("/createKart")
    private ResponseEntity<?>createKart(@RequestBody Kart kart){
        String createKartResponse = kartInterface.createKartData(kart);

        if (createKartResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(createKartResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred Backend");
        }
    }

//    @GetMapping("/getAllKartData/{pId}")
//    private ResponseEntity<?>getKartData(Long pId){
//
//        List<Kart> getAllKartResponse = kartInterface.getKartData(pId);
//
//        if (getAllKartResponse != null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(getAllKartResponse);
//        }else {
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body("Error Occurred Backend");
//        }
//    }
}
