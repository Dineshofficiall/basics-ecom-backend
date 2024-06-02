package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
