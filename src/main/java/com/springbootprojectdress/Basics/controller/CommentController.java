package com.springbootprojectdress.Basics.controller;


import com.springbootprojectdress.Basics.entity.Comment;
import com.springbootprojectdress.Basics.entity.Products;
import com.springbootprojectdress.Basics.serviceInterface.CommentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Basics-Comments")
public class CommentController {

    @Autowired
    CommentInterface commentInterface;

    //  create-Comment
    @PostMapping("/createNewComment")
    public ResponseEntity<?> commentCreate(@RequestBody Comment comment){
        String commentResponse = commentInterface.createNewComment(comment);

        if (commentResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(commentResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

    //  allComment-get
    @GetMapping("/allComment/{pId}")
    public ResponseEntity<?> allProduct(@PathVariable Long pId){
        List<Comment> allCommentResponse = commentInterface.getAllComment(pId);

        if (allCommentResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(allCommentResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

    //  delete-Comment
    @DeleteMapping("/deleteComment/{commentId}")
    public ResponseEntity<?> singleProduct(@PathVariable Long commentId){
        String DeleteResponse = commentInterface.deleteSingleComment(commentId);

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
