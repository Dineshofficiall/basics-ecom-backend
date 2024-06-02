package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Feedback;

import java.util.List;

public interface FeedbackInterface {

//  1.savingFeedback
    Feedback saveFeedback(Feedback feedbackObj);

//  2.getSingleFeedback
    List<Feedback> singleFeedback(Long userId);

//  3.getAllFeedback
    List<Feedback> allFeedback();
}
