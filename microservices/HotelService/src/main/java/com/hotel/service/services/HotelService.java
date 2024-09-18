package com.hotel.service.services;

import com.hotel.service.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {


    public Hotel createHotel(Hotel hotel);

    public Hotel getHotel(String hotelId);

    public List<Hotel> getAllHotels();

    public void deleteHotel(String hotelId);

    public Hotel updateHotel(Hotel hotel);
}
