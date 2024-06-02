package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.Feedback;
import com.springbootprojectdress.Basics.serviceInterface.FeedbackInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basics-feedback")
public class FeedbackController {

    @Autowired
    FeedbackInterface feedbackInterface;

//  save feedBack
    @PostMapping("/saveFeedback")
    public ResponseEntity<?> postFeedBack(@RequestBody Feedback feedbackObj){
        Feedback feedback = feedbackInterface.saveFeedback(feedbackObj);

        if (feedback != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(feedback);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred FeedBack PostMethod");
        }
    }

//  getSingleFeedback
    @GetMapping("/singleFeedback")
    public ResponseEntity<?> getSingleFeedback(@PathVariable Long userId){
        List<Feedback> feedbacks = feedbackInterface.singleFeedback(userId);

        if (feedbacks != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(feedbacks);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred in get method");
        }
    }

//  getAllFeedBack
    @GetMapping("/allFeedback")
    public ResponseEntity<?> getAllFeedback(){
        List<Feedback> feedbacks = feedbackInterface.allFeedback();

        if (feedbacks != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(feedbacks);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Error Occurred in getAll method");
        }
    }
}
