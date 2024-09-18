package com.user.service.services.impl;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.external.services.RatingService;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User createUser(User user) {

        user.setUserId(UUID.randomUUID().toString());

        return this.userRepository.save(user);

    }

    @Override
    public User getUser(String userId) {

        User user = this.userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server :" + userId));


 //       "http://localhost:8083/ratings/user/" + userId
 //             byUsing RestTemplate
//        Rating[] ratings = this.restTemplate.getForObject("http://RATINGSERVICE/ratings/user/" + user.getUserId(), Rating[].class);
//        List<Rating> ratingList = Arrays.stream(ratings).toList();

        //By using feignClient

        List<Rating> ratingList = this.ratingService.getAllRatingsById(user.getUserId());

        List<Rating> ratingList1 = ratingList.stream().map(rating -> {
          //  Hotel hotel = this.restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);

            Hotel hotel = this.hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList1);
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> all = this.userRepository.findAll();

        for (User user : all) {
//            Rating[] ratings = this.restTemplate.getForObject("http://RATINGSERVICE/ratings/user/" + user.getUserId(), Rating[].class);
//            user.setRatings(Arrays.stream(ratings).toList());

           List<Rating> ratings = this.ratingService.getAllRatingsById(user.getUserId());
           user.setRatings(ratings);

             for (Rating rating : ratings) {
//                Hotel hotel = this.restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//                rating.setHotel(hotel);

                Hotel hotel = this.hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);

            }

        }


        return all;
    }

    @Override
    public void deleteUser(String userId) {

        this.userRepository.deleteById(userId);

    }

    @Override
    public User updateUser(User user) {
        User save = this.userRepository.save(user);

        return save;
    }
}
