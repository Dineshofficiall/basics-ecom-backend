package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
