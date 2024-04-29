package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Rating;

import java.util.List;

public interface RatingInterface {

    String createNewRating(Rating rating);

    List<Rating> getAllRatings();

    String deleteSingleRating(Long ratingId);
}
