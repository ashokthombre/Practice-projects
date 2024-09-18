package com.rating.service.services;

import com.rating.service.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {


    public Rating createRating(Rating rating);

    public Rating getRating(String ratingId);


    public List<Rating> getAllRating();

    public void deleteRating(String ratingId);

    public Rating updateRating(Rating rating);

    public List<Rating> getRatingByUserId(String userId);

    public List<Rating> getRatingByHotelId(String hotelId);
}
