package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Comment;

import java.util.List;

public interface CommentInterface {

    String createNewComment(Comment comment);

    List<Comment> getAllComment();

    String deleteSingleComment(Long commentId);
}
