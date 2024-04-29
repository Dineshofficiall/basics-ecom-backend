package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Rating;
import com.springbootprojectdress.Basics.repositiory.RatingRepository;
import com.springbootprojectdress.Basics.serviceInterface.RatingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingImplementation implements RatingInterface {

    @Autowired
    RatingRepository ratingRepository;


    public String createNewRating(Rating rating) {
        ratingRepository.save(rating);
        return "created successfully";
    }


    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }


    public String deleteSingleRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
        return "deleted successfully";
    }
}
