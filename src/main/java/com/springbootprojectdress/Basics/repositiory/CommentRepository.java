package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Comment;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByProductId(Long pId);
}
