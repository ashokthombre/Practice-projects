package com.hotel.service.services.impl;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repositories.HotelRepository;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {

        hotel.setId(UUID.randomUUID().toString());

        Hotel save = this.hotelRepository.save(hotel);
        return save;
    }

    @Override
    public Hotel getHotel(String hotelId) {

        Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found " + hotelId));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {

        List<Hotel> all = this.hotelRepository.findAll();
        if (all==null)
        {
            throw new ResourceNotFoundException("No Resource Available.");
        }

        return all;
    }

    @Override
    public void deleteHotel(String hotelId) {

        this.hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {

        Hotel save = this.hotelRepository.save(hotel);
        return save;
    }
}
