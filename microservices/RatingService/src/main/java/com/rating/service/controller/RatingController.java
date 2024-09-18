package com.rating.service.controller;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {

        Rating rating1 = this.ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable("ratingId") String ratingId)
    {
        Rating rating = this.ratingService.getRating(ratingId);
        return ResponseEntity.ok().body(rating);
    }
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin') || hasAuthority('Normal')")
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {

        List<Rating> allRating = this.ratingService.getAllRating();
        return ResponseEntity.ok().body(allRating);

    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<?> deleteRating(@PathVariable("ratingId") String ratingId)
    {

        this.ratingService.deleteRating(ratingId);
        return ResponseEntity.ok().body("Rating deleted successfully...");
    }

    @PutMapping
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating)
    {
        Rating rating1 = this.ratingService.updateRating(rating);
        return ResponseEntity.ok().body(rating1);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId)
    {
        List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);

        return ResponseEntity.ok().body(ratingByUserId);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") String hotelId)
    {
        List<Rating> ratingByHotelId = this.ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok().body(ratingByHotelId);
    }


}
