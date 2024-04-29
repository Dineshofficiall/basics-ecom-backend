package com.springbootprojectdress.Basics.controller;


import com.springbootprojectdress.Basics.entity.Rating;
import com.springbootprojectdress.Basics.serviceInterface.RatingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Basics-Comments")
public class RatingController {

    @Autowired
    RatingInterface ratingInterface;

    //  create-Comment
    @PostMapping("/createRating")
    public ResponseEntity<?> createRating(@RequestBody Rating rating){
        String commentResponse = ratingInterface.createNewRating(rating);

        if (commentResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(commentResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

    //  allRatings-get
    @GetMapping("/allRatings")
    public ResponseEntity<?> allRatings(){
        List<Rating> allRatingsResponse = ratingInterface.getAllRatings();

        if (allRatingsResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(allRatingsResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

    //  delete-Comment
    @DeleteMapping("/deleteRating/{ratingId}")
    public ResponseEntity<?> deleteRating(@PathVariable Long ratingId){
        String DeleteResponse = ratingInterface.deleteSingleRating(ratingId);

        if (DeleteResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(DeleteResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }
}
