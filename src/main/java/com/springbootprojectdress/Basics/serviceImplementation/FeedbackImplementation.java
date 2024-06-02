package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Feedback;
import com.springbootprojectdress.Basics.repositiory.FeedbackRepository;
import com.springbootprojectdress.Basics.serviceInterface.FeedbackInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FeedbackImplementation implements FeedbackInterface {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(Feedback feedbackObj) {
        return feedbackRepository.save(feedbackObj);
    }

    public List<Feedback> singleFeedback(Long userId) {
        return feedbackRepository.findAllById(Collections.singleton(userId));
    }

    public List<Feedback> allFeedback() {
        return feedbackRepository.findAll();
    }
}
