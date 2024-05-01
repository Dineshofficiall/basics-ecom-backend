package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Comment;

import java.util.List;

public interface CommentInterface {

    String createNewComment(Comment comment);

    List<Comment> getAllComment(Long pId);

    String deleteSingleComment(Long commentId);
}
