package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Comment;
import com.springbootprojectdress.Basics.repositiory.CommentRepository;
import com.springbootprojectdress.Basics.serviceInterface.CommentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentImplementation implements CommentInterface {

    @Autowired
    CommentRepository commentRepository;


    public String createNewComment(Comment comment) {
        comment.setCreatedAt(new Date());
        commentRepository.save(comment);
        return "Created Successfully";
    }


    public List<Comment> getAllComment(Long pId) {
        return commentRepository.findByProductId(pId);
    }


    public String deleteSingleComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return "delete successfully";
    }
}
