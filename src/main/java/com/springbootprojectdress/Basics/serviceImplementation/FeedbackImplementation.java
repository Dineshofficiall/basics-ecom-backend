package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Feedback;
import com.springbootprojectdress.Basics.entity.UserFeedback;
import com.springbootprojectdress.Basics.entity.Users;
import com.springbootprojectdress.Basics.repositiory.FeedbackRepository;
import com.springbootprojectdress.Basics.repositiory.UserRepository;
import com.springbootprojectdress.Basics.serviceInterface.FeedbackInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FeedbackImplementation implements FeedbackInterface {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Feedback saveFeedback(Feedback feedbackObj) {
        List<Feedback> feedback = feedbackRepository.findByUserId(feedbackObj.getUserId());
        if (feedback.isEmpty()){
            return null;
        }
        else {
            return feedbackRepository.save(feedbackObj);
        }
    }

    public List<Feedback> singleFeedback(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }

    public List<UserFeedback> allFeedback() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        List<UserFeedback> userFeedbackList = new ArrayList<>();

        for (Feedback feedback : feedbacks){
            UserFeedback userFeedback = new UserFeedback();
            userFeedback.setFeedback(feedback.getFeedback());
            Users users = getUserForFeedback(feedback.getUserId());
            userFeedback.setUsers(users);
            userFeedbackList.add(userFeedback);
        }
        return userFeedbackList;
    }

    private Users getUserForFeedback(Long userId) {
        Query query = entityManager.createNativeQuery
                ("SELECT user_name, user_mail FROM users WHERE id = :userId");
        query.setParameter("userId", userId);
        List<Object[]> res = query.getResultList();
        Users users = new Users();
        users.setUserName((String) res.get(0)[0]);
        users.setMail((String) res.get(0)[1]);
        return users;
    }
}
