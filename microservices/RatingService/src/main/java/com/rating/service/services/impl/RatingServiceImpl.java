package com.rating.service.services.impl;

import com.rating.service.entities.Rating;
import com.rating.service.exceptions.ResourceNotFoundException;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {


        rating.setRatingId(UUID.randomUUID().toString());

        Rating save = this.ratingRepository.save(rating);
        return save;
    }

    @Override
    public Rating getRating(String ratingId) {

        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Not Found Rating." + ratingId));

        return rating;
    }

    @Override
    public List<Rating> getAllRating() {

        List<Rating> all = this.ratingRepository.findAll();
        return all;
    }

    @Override
    public void deleteRating(String ratingId) {

        this.ratingRepository.deleteById(ratingId);

    }

    @Override
    public Rating updateRating(Rating rating) {

        Rating save = this.ratingRepository.save(rating);
        return save;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {

        List<Rating> byUserId = this.ratingRepository.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {

        List<Rating> byHotelId = this.ratingRepository.findByHotelId(hotelId);
        return byHotelId;
    }
}
